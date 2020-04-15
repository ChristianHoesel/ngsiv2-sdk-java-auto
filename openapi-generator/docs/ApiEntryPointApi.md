# ApiEntryPointApi

All URIs are relative to *http://orion.lab.fiware.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**retrieveAPIResources**](ApiEntryPointApi.md#retrieveAPIResources) | **GET** /v2 | Retrieve API Resources


<a name="retrieveAPIResources"></a>
# **retrieveAPIResources**
> RetrieveApiResourcesResponse retrieveAPIResources()

Retrieve API Resources

This resource does not have any attributes. Instead it offers the initial API affordances in the form of the links in the JSON body. It is recommended to follow the “url” link values, [Link](https://tools.ietf.org/html/rfc5988) or Location headers where applicable to retrieve resources. Instead of constructing your own URLs, to keep your client decoupled from implementation details.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ApiEntryPointApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://orion.lab.fiware.org");

    ApiEntryPointApi apiInstance = new ApiEntryPointApi(defaultClient);
    try {
      RetrieveApiResourcesResponse result = apiInstance.retrieveAPIResources();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiEntryPointApi#retrieveAPIResources");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RetrieveApiResourcesResponse**](RetrieveApiResourcesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

