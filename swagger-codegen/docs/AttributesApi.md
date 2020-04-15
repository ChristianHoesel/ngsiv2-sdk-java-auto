# AttributesApi

All URIs are relative to *http://orion.lab.fiware.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAttributeData**](AttributesApi.md#getAttributeData) | **GET** /v2/entities/{entityId}/attrs/{attrName} | Get attribute data
[**removeASingleAttribute**](AttributesApi.md#removeASingleAttribute) | **DELETE** /v2/entities/{entityId}/attrs/{attrName} | Remove a Single Attribute
[**updateAttributeData**](AttributesApi.md#updateAttributeData) | **PUT** /v2/entities/{entityId}/attrs/{attrName} | Update Attribute Data


<a name="getAttributeData"></a>
# **getAttributeData**
> GetAttributeDataResponse getAttributeData(entityId, attrName, type, metadata)

Get attribute data

Returns a JSON object with the attribute data of the attribute. The object follows the JSON representation for attributes (described in \&quot;JSON Attribute Representation\&quot; section). Response: * Successful operation uses 200 OK. * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AttributesApi;


AttributesApi apiInstance = new AttributesApi();
String entityId = "entityId_example"; // String | Id of the entity
String attrName = "attrName_example"; // String | Name of the attribute to be retrieved.
String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
String metadata = "metadata_example"; // String | A list of metadata names to include in the response. See \"Filtering out attributes and metadata\" section for more detail.
try {
    GetAttributeDataResponse result = apiInstance.getAttributeData(entityId, attrName, type, metadata);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttributesApi#getAttributeData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityId** | **String**| Id of the entity |
 **attrName** | **String**| Name of the attribute to be retrieved. |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]
 **metadata** | **String**| A list of metadata names to include in the response. See \&quot;Filtering out attributes and metadata\&quot; section for more detail. | [optional]

### Return type

[**GetAttributeDataResponse**](GetAttributeDataResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeASingleAttribute"></a>
# **removeASingleAttribute**
> removeASingleAttribute(entityId, attrName, type)

Remove a Single Attribute

Removes an entity attribute. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AttributesApi;


AttributesApi apiInstance = new AttributesApi();
String entityId = "entityId_example"; // String | Id of the entity.
String attrName = "attrName_example"; // String | Attribute name.
String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
try {
    apiInstance.removeASingleAttribute(entityId, attrName, type);
} catch (ApiException e) {
    System.err.println("Exception when calling AttributesApi#removeASingleAttribute");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityId** | **String**| Id of the entity. |
 **attrName** | **String**| Attribute name. |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAttributeData"></a>
# **updateAttributeData**
> updateAttributeData(entityId, attrName, contentType, body, type)

Update Attribute Data

The request payload is an object representing the new attribute data. Previous attribute data is replaced by the one in the request. The object follows the JSON representation for attributes (described in \&quot;JSON Attribute Representation\&quot; section). Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AttributesApi;


AttributesApi apiInstance = new AttributesApi();
String entityId = "entityId_example"; // String | Id of the entity to update
String attrName = "attrName_example"; // String | Attribute name
String contentType = "contentType_example"; // String | 
UpdateAttributeDataRequest body = new UpdateAttributeDataRequest(); // UpdateAttributeDataRequest | 
String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
try {
    apiInstance.updateAttributeData(entityId, attrName, contentType, body, type);
} catch (ApiException e) {
    System.err.println("Exception when calling AttributesApi#updateAttributeData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityId** | **String**| Id of the entity to update |
 **attrName** | **String**| Attribute name |
 **contentType** | **String**|  |
 **body** | [**UpdateAttributeDataRequest**](UpdateAttributeDataRequest.md)|  |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

