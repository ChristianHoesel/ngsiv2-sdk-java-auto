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
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ApiEntryPointApi;


ApiEntryPointApi apiInstance = new ApiEntryPointApi();
try {
    RetrieveApiResourcesResponse result = apiInstance.retrieveAPIResources();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApiEntryPointApi#retrieveAPIResources");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RetrieveApiResourcesResponse**](RetrieveApiResourcesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

