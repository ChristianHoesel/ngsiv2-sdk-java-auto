# BatchOperationsApi

All URIs are relative to *http://orion.lab.fiware.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**notify**](BatchOperationsApi.md#notify) | **POST** /v2/op/notify | Notify
[**query**](BatchOperationsApi.md#query) | **POST** /v2/op/query | Query
[**update**](BatchOperationsApi.md#update) | **POST** /v2/op/update | Update


<a name="notify"></a>
# **notify**
> notify(contentType, body, options)

Notify

This operation is intended to consume a notification payload so that all the entity data included by such notification is persisted, overwriting if necessary. This operation is useful when one NGSIv2 endpoint is subscribed to another NGSIv2 endpoint (federation scenarios).  The request payload must be an NGSIv2 notification payload.  The behaviour must be exactly the same as &#x60;POST /v2/op/update&#x60; with &#x60;actionType&#x60; equal to &#x60;append&#x60;. Response code: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BatchOperationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://orion.lab.fiware.org");

    BatchOperationsApi apiInstance = new BatchOperationsApi(defaultClient);
    String contentType = "contentType_example"; // String | 
    NotifyRequest body = new NotifyRequest(); // NotifyRequest | 
    String options = "options_example"; // String | Options dictionary
    try {
      apiInstance.notify(contentType, body, options);
    } catch (ApiException e) {
      System.err.println("Exception when calling BatchOperationsApi#notify");
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
 **contentType** | **String**|  |
 **body** | [**NotifyRequest**](NotifyRequest.md)|  |
 **options** | **String**| Options dictionary | [optional] [enum: keyValues]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="query"></a>
# **query**
> List&lt;QueryResponse&gt; query(contentType, body, limit, offset, orderBy, options)

Query

The response payload is an Array containing one object per matching entity, or an empty array &#x60;[]&#x60; if  no entities are found. The entities follow the JSON entity representation format (described in the section \&quot;JSON Entity Representation\&quot;). The payload may contain the following elements (all of them optional): + &#x60;entities&#x60;: a list of entites to search for. Each element is represented by a JSON object with the   following elements:     + &#x60;id&#x60; or &#x60;idPattern&#x60;: Id or pattern of the affected entities. Both cannot be used at the same       time, but one of them must be present.     + &#x60;type&#x60; or &#x60;typePattern&#x60;: Type or type pattern of the entities to search for. Both cannot be used at       the same time. If omitted, it means \&quot;any entity type\&quot;. + &#x60;attrs&#x60;: List of attributes to be provided (if not specified, all attributes). + &#x60;expression&#x60;: an expression composed of &#x60;q&#x60;, &#x60;mq&#x60;, &#x60;georel&#x60;, &#x60;geometry&#x60; and &#x60;coords&#x60; (see \&quot;List    entities\&quot; operation above about this field). + &#x60;metadata&#x60;: a list of metadata names to include in the response.    See \&quot;Filtering out attributes and metadata\&quot; section for more detail. Response code: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BatchOperationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://orion.lab.fiware.org");

    BatchOperationsApi apiInstance = new BatchOperationsApi(defaultClient);
    String contentType = "contentType_example"; // String | 
    QueryRequest body = new QueryRequest(); // QueryRequest | 
    Double limit = 3.4D; // Double | Limit the number of entities to be retrieved.
    Double offset = 3.4D; // Double | Skip a number of records.
    String orderBy = "orderBy_example"; // String | Criteria for ordering results. See \"Ordering Results\" section for details.
    String options = "options_example"; // String | Options dictionary
    try {
      List<QueryResponse> result = apiInstance.query(contentType, body, limit, offset, orderBy, options);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BatchOperationsApi#query");
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
 **contentType** | **String**|  |
 **body** | [**QueryRequest**](QueryRequest.md)|  |
 **limit** | **Double**| Limit the number of entities to be retrieved. | [optional]
 **offset** | **Double**| Skip a number of records. | [optional]
 **orderBy** | **String**| Criteria for ordering results. See \&quot;Ordering Results\&quot; section for details. | [optional]
 **options** | **String**| Options dictionary | [optional] [enum: count, keyValues, values, unique]

### Return type

[**List&lt;QueryResponse&gt;**](QueryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="update"></a>
# **update**
> update(contentType, body, options)

Update

This operation allows to create, update and/or delete several entities in a single batch operation. The payload is an object with two properties: + &#x60;actionType&#x60;, to specify the kind of update action to do: either &#x60;append&#x60;, &#x60;appendStrict&#x60;, &#x60;update&#x60;,   &#x60;delete&#x60;, or &#x60;replace&#x60;. + &#x60;entities&#x60;, an array of entities, each entity specified using the JSON entity representation format   (described in the section \&quot;JSON Entity Representation\&quot;). This operation is split in as many individual operations as entities in the &#x60;entities&#x60; vector, so the &#x60;actionType&#x60; is executed for each one of them. Depending on the &#x60;actionType&#x60;, a mapping with regular non-batch operations can be done: * &#x60;append&#x60;: maps to &#x60;POST /v2/entities&#x60; (if the entity does not already exist) or &#x60;POST /v2/entities/&lt;id&gt;/attrs&#x60;   (if the entity already exists). * &#x60;appendStrict&#x60;: maps to &#x60;POST /v2/entities&#x60; (if the entity does not already exist) or   &#x60;POST /v2/entities/&lt;id&gt;/attrs?options&#x3D;append&#x60; (if the entity already exists). * &#x60;update&#x60;: maps to &#x60;PATCH /v2/entities/&lt;id&gt;/attrs&#x60;. * &#x60;delete&#x60;: maps to &#x60;DELETE /v2/entities/&lt;id&gt;/attrs/&lt;attrName&gt;&#x60; on every attribute included in the entity or   to &#x60;DELETE /v2/entities/&lt;id&gt;&#x60; if no attribute were included in the entity. * &#x60;replace&#x60;: maps to &#x60;PUT /v2/entities/&lt;id&gt;/attrs&#x60;. Response: * Successful operation uses 204 No Content. * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BatchOperationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://orion.lab.fiware.org");

    BatchOperationsApi apiInstance = new BatchOperationsApi(defaultClient);
    String contentType = "contentType_example"; // String | 
    UpdateRequest body = new UpdateRequest(); // UpdateRequest | 
    String options = "options_example"; // String | Options dictionary
    try {
      apiInstance.update(contentType, body, options);
    } catch (ApiException e) {
      System.err.println("Exception when calling BatchOperationsApi#update");
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
 **contentType** | **String**|  |
 **body** | [**UpdateRequest**](UpdateRequest.md)|  |
 **options** | **String**| Options dictionary | [optional] [enum: keyValues]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** |  |  -  |

