=begin
#--

Copyright 2012-2013 inBloom, Inc. and its affiliates.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

=end
require "active_resource/base"
# This is the main controller of the Databrowser.
# We try to "Wrap" all api requests in this one single point
# and do some clever work with filters and routing to make this work.
# The basic flow goes like this:
# * The Api request is routed as parameters to this controller
# * The set_url field deals with that parameter as well as search parameters
# * The show action creates the new model with the url, searches, and pages.
# We make heavy use of params which is everything that comes into
# this controller after /entities/
class EntitiesController < ApplicationController
  before_filter :set_url

  # What we see mostly here is that we are looking for searh parameters.
  # Now, we also try to simply set up the search field and then remove it
  # from the parameters so that we don't confuse the API by passing it
  # through later.
  #
  # Here we tell the Entity model that it's url is the thing that was passed
  # through in params. Which is how we are able to wrap the entire
  # api through one place.
  def set_url
    @search_field = nil
    case params[:search_type]
    when /studentById/
      @search_field = "_id,studentUniqueStateId"
    when /staffById/
      @search_field = "_id,staffUniqueStateId"
    when /edOrgById/
      @search_field = "_id"
    when /parentsById/
      @search_field = "_id"
   #The q is for query parameters. So what the api does with that is basically just forwards it on to elastic search. 
   #It doesn't even really stop in between other than to format the url in a search indexer friendly way and pass the results back out.
    when /students/
      @search_field = "q"
    when /staff/
      @search_field = "q"
    when /parents/
      @search_field = "q"
    when /educationOrganizations/
      @search_field = "q"
    end
    params[:other] = params[:search_type] if @search_field
    if params[:search_type] == "studentById"
      Entity.url_type = "search/students"

    elsif params[:search_type] == "staffById"
      Entity.url_type = "search/staff,teachers"

    elsif params[:search_type] == "edOrgById"
        Entity.url_type = "search/educationOrganizations"

    #parent by ID?
    elsif params[:search_type] == "parentsById"
        Entity.url_type = "search/parents"

    else
      Entity.url_type = params[:other]
    end
    params.delete(:search_type)
    Entity.format = ActiveResource::Formats::JsonLinkFormat
  end

  # Ignoring some of the complicated parts, is we use the configured
  # model from set_url to make the Api call to get the data from the Api.
  #
  # Because we are trying to be generic with the data we get back, we handle
  # two special cases. The first is if params is 'home' which is a 
  # special home page in the Api. So if we call that we, render the index
  # page instead of the normal 'show'.
  # 
  # Second, if we only got one entity back, like the data for a single student
  # we go ahead and wrap that up into an array with that as the only element so
  # that our view logic can be simpler.
  #
  # As for the complicated parts, we do a few things, first is we detect if we
  # were passed any search parameters, and augment the Api call to deal with that
  # instead.
  #
  # Second, if we see any offset in params then we make the call to
  # grab the next page of data from the Api.
  def show
    
    # This section was put here for pagination. It sets the offset to 0 if not
    # set and then has a session and params variable for the limit. If the params
    # limit is set, it takes precedence. If there is no limit, the default is set
    # to the first item in the paginate_ipp array in views.yml
    if params[:offset].nil?
      params[:offset] = 0
    end
    if params[:limit].nil? and session[:limit].nil?
      params[:limit] = VIEW_CONFIG['paginate_ipp'].first.to_i
      session[:limit] = params[:limit]
    elsif !params[:limit].nil?
      session[:limit] = params[:limit]
    elsif params[:limit].nil? and !session[:limit].nil?
      params[:limit] = session[:limit]
    end
    
    logger.debug params.inspect
    @page = Page.new
    if params[:search_id] && @search_field
      @entities = []
      @entities = Entity.get("", @search_field => params[:search_id].strip) if params[:search_id] && !params[:search_id].strip.empty?
      @entities = clean_up_results(@entities)
      flash.now[:notice] = "There were no entries matching your search" if @entities.size == 0 || @entities.nil?
    else
      query = params.reject {|k, v| k == 'controller' || k == 'action' || k == 'other' || k == 'search_id'}
      logger.debug {"Keeping query parameters #{query.inspect}"}
      @entities = Entity.get("", query)

      @headers = @entities.http_response
      @page = Page.new(@headers)
      @entities= clean_up_results(@entities)
    end
    if params[:other] == 'home'
      render :index
      return
    end

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json:  {
         entities: @entities,
         headers: @headers
         }
      }
      format.js #show.js.erb
    end
  end
  
  private
  def clean_up_results(entities)
    tmp = entities
    if entities.is_a?(Hash)
      tmp = Array.new()
      tmp.push(entities)
    end
    tmp
  end
end
