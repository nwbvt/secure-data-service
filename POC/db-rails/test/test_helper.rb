ENV["RAILS_ENV"] = "test"
require File.expand_path('../../config/environment', __FILE__)
require 'rails/test_help'

class ActiveSupport::TestCase
  # Setup all fixtures in test/fixtures/*.(yml|csv) for all tests in alphabetical order.
  #
  # Note: You'll currently still have to declare fixtures explicitly in integration tests
  # -- they do not yet inherit this setting
  # fixtures :all

  # Add more helper methods to be used by all tests here...
  def load_fixture(name)
    path = File.join(Rails.root, "test", "fixtures", "#{name}.yml")
    return nil unless File.exists?(path)
    YAML::load(File.open path)
  end
  
  setup do
    @student_fixtures = load_fixture("entities")
    # @realm_fixtures = load_fixture("realms")
    ActiveResource::HttpMock.respond_to do |mock|
      mock.get "/api/rest/students?sessionId=", {"Accept" => "application/json"}, [@student_fixtures['one'], @student_fixtures['two']].to_json
      mock.get "/api/rest/teachers?sessionId=", {"Accept" => "application/json"}, [@student_fixtures['one'], @student_fixtures['two']].to_json
      mock.get "/api/rest/students/1?sessionId=", {"Accept" => "application/json"}, @student_fixtures['one'].to_json
      mock.get "/api/rest/students/2/targets?sessionId=", {"Accept" => "application/json"}, @student_fixtures['two'].to_json
    end
  end
end
