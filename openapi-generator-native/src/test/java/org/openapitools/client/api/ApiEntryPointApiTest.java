/*
 * FIWARE-NGSI v2 Specification
 * TODO: Add a description
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.RetrieveApiResourcesResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * API tests for ApiEntryPointApi
 */
@Ignore
public class ApiEntryPointApiTest {

    private final ApiEntryPointApi api = new ApiEntryPointApi();

    
    /**
     * Retrieve API Resources
     *
     * This resource does not have any attributes. Instead it offers the initial API affordances in the form of the links in the JSON body. It is recommended to follow the “url” link values, [Link](https://tools.ietf.org/html/rfc5988) or Location headers where applicable to retrieve resources. Instead of constructing your own URLs, to keep your client decoupled from implementation details.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveAPIResourcesTest() throws ApiException {
        RetrieveApiResourcesResponse response = 
        api.retrieveAPIResources();
        
        // TODO: test validations
    }
    
}
