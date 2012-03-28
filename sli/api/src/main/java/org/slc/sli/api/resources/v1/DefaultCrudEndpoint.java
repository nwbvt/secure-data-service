package org.slc.sli.api.resources.v1;

import org.slc.sli.api.config.AssociationDefinition;
import org.slc.sli.api.config.EntityDefinition;
import org.slc.sli.api.config.EntityDefinitionStore;
import org.slc.sli.api.representation.EntityBody;
import org.slc.sli.api.representation.ErrorResponse;
import org.slc.sli.api.resources.util.ResourceConstants;
import org.slc.sli.api.resources.util.ResourceUtil;
import org.slc.sli.api.service.query.ApiQuery;
import org.slc.sli.domain.NeutralCriteria;
import org.slc.sli.domain.NeutralQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prototype new api end points and versioning base class
 * 
 * @author srupasinghe
 * @author kmyers
 * 
 */
@Component
@Scope("request")
public class DefaultCrudEndpoint implements CrudEndpoint {
    /* The maximum number of values allowed in a comma separated string */
    public static final int MAX_MULTIPLE_UUIDS = 100;
    
    /* Access to entity definitions */
    private EntityDefinitionStore entityDefs;
    
    /* Logger utility to use to output debug, warning, or other messages to the "console" */
    private final Logger logger;
    
    /**
     * Encapsulates each ReST method's logic to allow for less duplication of precondition and
     * exception handling code.
     */
    protected static interface ResourceLogic {
        public Response run(EntityDefinition entityDef);
    }
    
    /**
     * Constructor.
     * 
     * @param entityDefs
     *            access to entity definitions
     */
    @Autowired
    public DefaultCrudEndpoint(EntityDefinitionStore entityDefs) {
        this(entityDefs, LoggerFactory.getLogger(DefaultCrudEndpoint.class));
    }
    
    /**
     * Constructor.
     * 
     * @param entityDefs
     *            access to entity definitions
     * @param logger
     *            Logger utility to use to output debug, warning, or other messages to the "console"
     */
    public DefaultCrudEndpoint(final EntityDefinitionStore entityDefs, final Logger logger) {
        if (entityDefs == null) {
            throw new NullPointerException("entityDefs");
        }
        if (logger == null) {
            throw new NullPointerException("logger");
        }
        this.entityDefs = entityDefs;
        this.logger = logger;
    }
    
    /**
     * Creates a new entity in a specific location or collection.
     * 
     * @param collectionName
     *            where the entity should be located
     * @param newEntityBody
     *            new map of keys/values for entity
     * @param headers
     *            HTTP header information (which includes request headers)
     * @param uriInfo
     *            URI information including path and query parameters
     * @return resulting status from request
     */
    @Override
    public Response create(final String collectionName, final EntityBody newEntityBody, final HttpHeaders headers,
            final UriInfo uriInfo) {
        return handle(collectionName, entityDefs, new ResourceLogic() {
            @Override
            public Response run(EntityDefinition entityDef) {
                String id = entityDef.getService().create(newEntityBody);
                String uri = ResourceUtil.getURI(uriInfo, PathConstants.V1, PathConstants.TEMP_MAP.get(entityDef.getResourceName()), id).toString();
                return Response.status(Status.CREATED).header("Location", uri).build();
            }
        });
    }
    
    /**
     * Reads one or more entities from a specific location or collection.
     * 
     * @param resourceName
     *            where the entity should be located
     * @param key
     *            field to be queried against
     * @param value
     *            expected value to be found in the key
     * @param headers
     *            HTTP header information (which includes request headers)
     * @param uriInfo
     *            URI information including path and query parameters
     * @return requested information or error status
     */
    @Override
    public Response read(final String resourceName, final String key, final String value, final HttpHeaders headers,
            final UriInfo uriInfo) {
        // /v1/entity/{id}/associations
        return handle(resourceName, entityDefs, new ResourceLogic() {
            @Override
            public Response run(final EntityDefinition entityDef) {
                logger.debug("Attempting to read from {} where {} = {}", new Object[] {
                        entityDef.getStoredCollectionName(), key, value});
                
                long totalCount = 0;
                if (entityDef instanceof AssociationDefinition) {
                    AssociationDefinition associationDefinition = (AssociationDefinition) entityDef;
                    totalCount = associationDefinition.getService().countAssociationsTo(value, new ApiQuery(uriInfo));
                }
                
                NeutralQuery neutralQuery = new ApiQuery(uriInfo);
                //neutralQuery.addCriteria(new NeutralCriteria(key, "=", value));
                List<String> valueList = new ArrayList<String>(Arrays.asList(value.split(",")));
                neutralQuery.addCriteria(new NeutralCriteria(key, "in", valueList));
                
                // a new list to store results
                List<EntityBody> results = new ArrayList<EntityBody>();
                
                // list all entities matching query parameters and iterate over results
                for (EntityBody entityBody : entityDef.getService().list(neutralQuery)) {
                    entityBody.put(ResourceConstants.LINKS, ResourceUtil.getAssociationAndReferenceLinksForEntity(
                            entityDefs, entityDef, entityBody, uriInfo));
                    // add entity to resulting response
                    results.add(entityBody);
                }
                
                
                Response.ResponseBuilder responseBuilder;
                responseBuilder = Response.ok(results);
                return addPagingHeaders(responseBuilder, totalCount, uriInfo).build();
                
                // turn results into response
                // return Response.ok(results).build();
            }
        });
    }
    
    
    /**
     * Searches "resourceName" for entries where "key" equals "value", then for each result
     * uses "idkey" field's value to query "resolutionResourceName" against the ID field.
     * 
     * @param resourceName
     *            where the entity should be located
     * @param key
     *            field to be queried against (when searching resources)
     * @param value
     *            expected value to be found in the key
     * @param idKey
     *            field in resource that contains the ID to be resolved
     * @param resolutionResourceName
     *            where to query for the entity with the ID taken from the "idKey" field
     * @param headers
     *            HTTP header information (which includes request headers)
     * @param uriInfo
     *            URI information including path and query parameters
     * @return requested information or error status
     */
    @Override
    public Response read(final String resourceName, final String key, final String value, final String idKey,
            final String resolutionResourceName, final HttpHeaders headers, final UriInfo uriInfo) {
        // /v1/entity/{id}/associations/entity
        return handle(resourceName, entityDefs, new ResourceLogic() {
            @Override
            public Response run(final EntityDefinition entityDef) {
                // look up information on association
                EntityDefinition endpointEntity = entityDefs.lookupByResourceName(resolutionResourceName);
                String resource1 = entityDef.getStoredCollectionName();
                String resource2 = endpointEntity.getStoredCollectionName();
                
                // write some information to debug
                logger.debug("Attempting to list from {} where {} = {}", new Object[] {resource1, key, value});
                logger.debug("Then for each result, ");
                logger.debug(" going to read from {} where \"_id\" = {}.{}", new Object[] {
                        resource2, resource1, idKey});
                

                NeutralQuery endpointNeutralQuery = new ApiQuery(uriInfo);
                NeutralQuery associationNeutralQuery = createAssociationNeutralQuery(endpointNeutralQuery, key, value, idKey);
                
                // final/resulting information
                List<EntityBody> finalResults = new ArrayList<EntityBody>();
                
                List<String> ids = new ArrayList<String>();
                // for each association
                for (EntityBody entityBody : entityDef.getService().list(associationNeutralQuery)) {
                    ids.add((String) entityBody.get(idKey));
                }
                
                if (ids.size() == 0) {
                    return Response.ok(finalResults).build();
                }
                
                endpointNeutralQuery.addCriteria(new NeutralCriteria("_id", "in", ids));
                for (EntityBody result : endpointEntity.getService().list(endpointNeutralQuery)) {
                    result.put(
                            ResourceConstants.LINKS,
                            ResourceUtil.getAssociationAndReferenceLinksForEntity(entityDefs,
                                    entityDefs.lookupByResourceName(resolutionResourceName), result, uriInfo));
                    finalResults.add(result);
                }
                
                return Response.ok(finalResults).build();
            }
        });
    }
    
    /**
     * Reads one or more entities from a specific location or collection.
     * 
     * @param resourceName
     *            where the entity should be located
     * @param idList
     *            a single ID or a comma separated list of IDs
     * @param headers
     *            HTTP header information (which includes request headers)
     * @param uriInfo
     *            URI information including path and query parameters
     * @return requested information or error status
     */
    @Override
    public Response read(final String resourceName, final String idList, final HttpHeaders headers,
            final UriInfo uriInfo) {
        // /v1/entity/{id}
        return handle(resourceName, entityDefs, new ResourceLogic() {
            @Override
            public Response run(EntityDefinition entityDef) {
                int idLength = idList.split(",").length;
                
                if (idLength > DefaultCrudEndpoint.MAX_MULTIPLE_UUIDS) {
                    Status errorStatus = Status.PRECONDITION_FAILED;
                    String errorMessage = "Too many GUIDs: " + idLength + " (input) vs "
                            + DefaultCrudEndpoint.MAX_MULTIPLE_UUIDS + " (allowed)";
                    return Response
                            .status(errorStatus)
                            .entity(new ErrorResponse(errorStatus.getStatusCode(), errorStatus.getReasonPhrase(),
                                    errorMessage)).build();
                }
                
                List<String> ids = new ArrayList<String>();
                
                for (String id : idList.split(",")) {
                    ids.add(id);
                }
                
                NeutralQuery neutralQuery = new ApiQuery(uriInfo);
                neutralQuery.addCriteria(new NeutralCriteria("_id", "in", ids));
                
                // final/resulting information
                List<EntityBody> finalResults = new ArrayList<EntityBody>();
                
                Iterable<EntityBody> entities;
                if (idLength == 1) {
                    entities = Arrays.asList(new EntityBody[] { entityDef.getService().get(idList, neutralQuery) });
                } else {
                    entities = entityDef.getService().list(neutralQuery);
                }
                
                for (EntityBody result : entities) {
                    if (result != null) {
                        result.put(ResourceConstants.LINKS, ResourceUtil.getAssociationAndReferenceLinksForEntity(
                                entityDefs, entityDef, result, uriInfo));
                    }
                    finalResults.add(result);
                }
                
                // Return results as an array if multiple IDs were requested (comma separated list),
                // single entity otherwise
                if (finalResults.isEmpty()) {
                    return Response.status(Status.NOT_FOUND).build();
                } else if (finalResults.size() == 1) {
                    return Response.ok(finalResults.get(0)).build();
                } else {
                    return Response.ok(finalResults).build();
                }
            }
        });
    }
    
    /**
     * Deletes a given entity from a specific location or collection.
     * 
     * @param resourceName
     *            where the entity should be located
     * @param id
     *            ID of object being deleted
     * @param headers
     *            HTTP header information (which includes request headers)
     * @param uriInfo
     *            URI information including path and query parameters
     * @return resulting status from request
     */
    @Override
    public Response delete(final String resourceName, final String id, final HttpHeaders headers, final UriInfo uriInfo) {
        return handle(resourceName, entityDefs, new ResourceLogic() {
            @Override
            public Response run(final EntityDefinition entityDef) {
                entityDef.getService().delete(id);
                return Response.status(Status.NO_CONTENT).build();
            }
        });
    }
    
    /**
     * Updates a given entity in a specific location or collection.
     * 
     * @param resourceName
     *            where the entity should be located
     * @param id
     *            ID of object being updated
     * @param newEntityBody
     *            new map of keys/values for entity
     * @param headers
     *            HTTP header information (which includes request headers)
     * @param uriInfo
     *            URI information including path and query parameters
     * @return resulting status from request
     */
    @Override
    public Response update(final String resourceName, final String id, final EntityBody newEntityBody,
            final HttpHeaders headers, final UriInfo uriInfo) {
        return handle(resourceName, entityDefs, new ResourceLogic() {
            @Override
            public Response run(EntityDefinition entityDef) {
                EntityBody copy = new EntityBody(newEntityBody);
                copy.remove(ResourceConstants.LINKS);
                logger.debug("updating entity {}", copy);
                entityDef.getService().update(id, copy);
                logger.debug("updating entity {}", copy);
                return Response.status(Status.NO_CONTENT).build();
            }
        });
    }
    
    /**
     * Reads all entities from a specific location or collection.
     * 
     * @param collectionName
     *            where the entity should be located
     * @param headers
     *            HTTP header information (which includes request headers)
     * @param uriInfo
     *            URI information including path and query parameters
     * @return requested information or error status
     */
    @Override
    public Response readAll(final String collectionName, final HttpHeaders headers, final UriInfo uriInfo) {
        return handle(collectionName, entityDefs, new ResourceLogic() {
            // v1/entity
            @Override
            public Response run(final EntityDefinition entityDef) {
                // final/resulting information
                List<EntityBody> results = new ArrayList<EntityBody>();
                
                for (EntityBody entityBody : entityDef.getService().list(new ApiQuery(uriInfo))) {
                    // if links should be included then put them in the entity body
                    entityBody.put(ResourceConstants.LINKS, ResourceUtil.getAssociationAndReferenceLinksForEntity(
                            entityDefs, entityDef, entityBody, uriInfo));
                    results.add(entityBody);
                }
                
                return Response.ok(results).build();
            }
        });
    }
    
    /* Utility methods */
    
    /**
     * Handle preconditions and exceptions.
     */
    private static Response handle(final String resourceName, final EntityDefinitionStore entityDefs,
            final ResourceLogic logic) {
        EntityDefinition entityDef = entityDefs.lookupByResourceName(resourceName);
        if (entityDef == null) {
            return Response
                    .status(Status.NOT_FOUND)
                    .entity(new ErrorResponse(Status.NOT_FOUND.getStatusCode(), Status.NOT_FOUND.getReasonPhrase(),
                            "Invalid resource path: " + resourceName)).build();
        }
        return logic.run(entityDef);
    }
    
    /**
     * Creates a query that looks up an association where key = value and only returns the specified field.
     * A convenience method for querying for associations when resolving their endpoints.
     * 
     * @param endpointNeutralQuery
     * @param key
     * @param value
     * @param includeField
     * @return
     */
    private NeutralQuery createAssociationNeutralQuery(NeutralQuery endpointNeutralQuery, String key, String value, String includeField) {
        NeutralQuery neutralQuery = new NeutralQuery();
        List<String> list = new ArrayList<String>(Arrays.asList(value.split(",")));
        neutralQuery.addCriteria(new NeutralCriteria(key, NeutralCriteria.CRITERIA_IN, list));
        neutralQuery.setIncludeFields(includeField);
        return neutralQuery;
    }
    
    private Response.ResponseBuilder addPagingHeaders(Response.ResponseBuilder resp, long total, UriInfo info) {
        if (null == info || null == info.getQueryParameters(true))
            return resp;

        MultivaluedMap<String, String> queryParams = info.getQueryParameters(true);
        
        int offset = Integer.parseInt(queryParams.containsKey(ParameterConstants.OFFSET) ? queryParams
                .getFirst(ParameterConstants.OFFSET) : ParameterConstants.DEFAULT_OFFSET);
        int limit = Integer.parseInt(queryParams.containsKey(ParameterConstants.LIMIT) ? queryParams
                .getFirst(ParameterConstants.LIMIT) : ParameterConstants.DEFAULT_LIMIT);
        
        int nextStart = offset + limit;
        if (nextStart < total) {
            String nextLink = info.getRequestUriBuilder().replaceQueryParam(ParameterConstants.OFFSET, nextStart)
                    .replaceQueryParam(ParameterConstants.LIMIT, limit).build().toString();
            resp.header(ParameterConstants.HEADER_LINK, "<" + nextLink + ">; rel=next");
        }
        if (offset > 0) {
            int prevStart = offset - limit;
            String prevLink = info.getRequestUriBuilder()
                    .replaceQueryParam(ParameterConstants.OFFSET, prevStart > 0 ? prevStart : 0)
                    .replaceQueryParam(ParameterConstants.LIMIT, limit).build().toString();
            resp.header(ParameterConstants.HEADER_LINK, "<" + prevLink + ">; rel=prev");
        }
        resp.header(ParameterConstants.HEADER_TOTAL_COUNT, total);
        return resp;
    }
}
