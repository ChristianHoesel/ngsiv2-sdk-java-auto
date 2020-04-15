# TypesApi

All URIs are relative to *http://orion.lab.fiware.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listEntityTypes**](TypesApi.md#listEntityTypes) | **GET** /v2/types/ | List Entity Types
[**retrieveEntityType**](TypesApi.md#retrieveEntityType) | **GET** /v2/types/{entityType} | Retrieve entity type



## listEntityTypes

> List&lt;ListEntityTypesResponse&gt; listEntityTypes(limit, offset, options)

List Entity Types

If the &#x60;values&#x60; option is not in use, this operation returns a JSON array with the entity types. Each element is a JSON object with information about the type: * &#x60;type&#x60; : the entity type name. * &#x60;attrs&#x60; : the set of attribute names along with all the entities of such type, represented in   a JSON object whose keys are the attribute names and whose values contain information of such   attributes (in particular a list of the types used by attributes with that name along with all the   entities). * &#x60;count&#x60; : the number of entities belonging to that type. If the &#x60;values&#x60; option is used, the operation returns a JSON array with a list of entity type names as strings. Results are ordered by entity &#x60;type&#x60; in alphabetical order. Response code: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TypesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://orion.lab.fiware.org");

        TypesApi apiInstance = new TypesApi(defaultClient);
        Double limit = 3.4D; // Double | Limit the number of types to be retrieved.
        Double offset = 3.4D; // Double | Skip a number of records.
        String options = "options_example"; // String | Options dictionary.
        try {
            List<ListEntityTypesResponse> result = apiInstance.listEntityTypes(limit, offset, options);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TypesApi#listEntityTypes");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Double**| Limit the number of types to be retrieved. | [optional]
 **offset** | **Double**| Skip a number of records. | [optional]
 **options** | **String**| Options dictionary. | [optional] [enum: count, values]

### Return type

[**List&lt;ListEntityTypesResponse&gt;**](ListEntityTypesResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |


## retrieveEntityType

> RetrieveEntityTypeResponse retrieveEntityType(entityType)

Retrieve entity type

This operation returns a JSON object with information about the type: * &#x60;attrs&#x60; : the set of attribute names along with all the entities of such type, represented in   a JSON object whose keys are the attribute names and whose values contain information of such   attributes (in particular a list of the types used by attributes with that name along with all the   entities). * &#x60;count&#x60; : the number of entities belonging to that type. Response code: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TypesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://orion.lab.fiware.org");

        TypesApi apiInstance = new TypesApi(defaultClient);
        String entityType = "entityType_example"; // String | Entity Type
        try {
            RetrieveEntityTypeResponse result = apiInstance.retrieveEntityType(entityType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TypesApi#retrieveEntityType");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity Type |

### Return type

[**RetrieveEntityTypeResponse**](RetrieveEntityTypeResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

