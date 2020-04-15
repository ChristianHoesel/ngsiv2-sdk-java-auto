# AttributeValueApi

All URIs are relative to *http://orion.lab.fiware.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAttributeValue**](AttributeValueApi.md#getAttributeValue) | **GET** /v2/entities/{entityId}/attrs/{attrName}/value | Get Attribute Value
[**updateAttributeValue**](AttributeValueApi.md#updateAttributeValue) | **PUT** /v2/entities/{entityId}/attrs/{attrName}/value | Update Attribute Value



## getAttributeValue

> GetAttributeValueResponse getAttributeValue(entityId, attrName, type)

Get Attribute Value

This operation returns the &#x60;value&#x60; property with the value of the attribute. * If attribute value is JSON Array or Object:   * If &#x60;Accept&#x60; header can be expanded to &#x60;application/json&#x60; or &#x60;text/plain&#x60; return the value as a JSON with a     response type of application/json or text/plain (whichever is the first in &#x60;Accept&#x60; header or     &#x60;application/json&#x60; in case of &#x60;Accept: *_/_*&#x60;).   * Else return a HTTP error \&quot;406 Not Acceptable: accepted MIME types: application/json, text/plain\&quot; * If attribute value is a string, number, null or boolean:   * If &#x60;Accept&#x60; header can be expanded to text/plain return the value as text. In case of a string, citation     marks are used at the begining and end.   * Else return a HTTP error \&quot;406 Not Acceptable: accepted MIME types: text/plain\&quot; Response: * Successful operation uses 200 OK. * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AttributeValueApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://orion.lab.fiware.org");

        AttributeValueApi apiInstance = new AttributeValueApi(defaultClient);
        String entityId = "entityId_example"; // String | Id of the entity in question
        String attrName = "attrName_example"; // String | Name of the attribute to be retrieved.
        String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
        try {
            GetAttributeValueResponse result = apiInstance.getAttributeValue(entityId, attrName, type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AttributeValueApi#getAttributeValue");
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
 **entityId** | **String**| Id of the entity in question |
 **attrName** | **String**| Name of the attribute to be retrieved. |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]

### Return type

[**GetAttributeValueResponse**](GetAttributeValueResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |


## updateAttributeValue

> updateAttributeValue(entityId, attrName, contentType, body, type)

Update Attribute Value

The request payload is the new attribute value. * If the request payload MIME type is &#x60;application/json&#x60;, then the value of the attribute is set to   the JSON object or array coded in the payload (if the payload is not a valid JSON document,   then an error is returned). * If the request payload MIME type is &#x60;text/plain&#x60;, then the following algorithm is applied to the   payload:   * If the payload starts and ends with citation-marks (&#x60;\&quot;&#x60;), the value is taken as a string     (the citation marks themselves are not considered part of the string)   * If &#x60;true&#x60; or &#x60;false&#x60;, the value is taken as a boolean.   * If &#x60;null&#x60;, the value is taken as null.   * If these first three tests &#39;fail&#39;, the text is interpreted as a number.   * If not a valid number, then an error is returned and the attribute&#39;s value is unchanged. The payload MIME type in the request is specified in the &#x60;Content-Type&#x60; HTTP header. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AttributeValueApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://orion.lab.fiware.org");

        AttributeValueApi apiInstance = new AttributeValueApi(defaultClient);
        String entityId = "entityId_example"; // String | Id of the entity to be updated.
        String attrName = "attrName_example"; // String | Attribute name.
        String contentType = "contentType_example"; // String | 
        UpdateAttributeValueRequest body = new UpdateAttributeValueRequest(); // UpdateAttributeValueRequest | 
        String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
        try {
            apiInstance.updateAttributeValue(entityId, attrName, contentType, body, type);
        } catch (ApiException e) {
            System.err.println("Exception when calling AttributeValueApi#updateAttributeValue");
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
 **entityId** | **String**| Id of the entity to be updated. |
 **attrName** | **String**| Attribute name. |
 **contentType** | **String**|  |
 **body** | [**UpdateAttributeValueRequest**](UpdateAttributeValueRequest.md)|  |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]

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
| **200** |  |  -  |

