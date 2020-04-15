# EntitiesApi

All URIs are relative to *http://orion.lab.fiware.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEntity**](EntitiesApi.md#createEntity) | **POST** /v2/entities | Create Entity
[**listEntities**](EntitiesApi.md#listEntities) | **GET** /v2/entities | List Entities
[**removeEntity**](EntitiesApi.md#removeEntity) | **DELETE** /v2/entities/{entityId} | Remove Entity
[**replaceAllEntityAttributes**](EntitiesApi.md#replaceAllEntityAttributes) | **PUT** /v2/entities/{entityId}/attrs | Replace all entity attributes
[**retrieveEntity**](EntitiesApi.md#retrieveEntity) | **GET** /v2/entities/{entityId} | Retrieve Entity
[**retrieveEntityAttributes**](EntitiesApi.md#retrieveEntityAttributes) | **GET** /v2/entities/{entityId}/attrs | Retrieve Entity Attributes
[**updateExistingEntityAttributes**](EntitiesApi.md#updateExistingEntityAttributes) | **PATCH** /v2/entities/{entityId}/attrs | Update Existing Entity Attributes
[**updateOrAppendEntityAttributes**](EntitiesApi.md#updateOrAppendEntityAttributes) | **POST** /v2/entities/{entityId}/attrs | Update or Append Entity Attributes


<a name="createEntity"></a>
# **createEntity**
> createEntity(contentType, body, options)

Create Entity

The payload is an object representing the entity to be created. The object follows the JSON entity representation format (described in a \&quot;JSON Entity Representation\&quot; section). Response: * Successful operation uses 201 Created (if upsert option is not used) or 204 No Content (if   upsert option is used). Response includes a &#x60;Location&#x60; header with the URL of the   created entity. * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EntitiesApi;


EntitiesApi apiInstance = new EntitiesApi();
String contentType = "contentType_example"; // String | 
CreateEntityRequest body = new CreateEntityRequest(); // CreateEntityRequest | 
String options = "options_example"; // String | Options dictionary
try {
    apiInstance.createEntity(contentType, body, options);
} catch (ApiException e) {
    System.err.println("Exception when calling EntitiesApi#createEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  |
 **body** | [**CreateEntityRequest**](CreateEntityRequest.md)|  |
 **options** | **String**| Options dictionary | [optional] [enum: keyValues, upsert]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listEntities"></a>
# **listEntities**
> List&lt;ListEntitiesResponse&gt; listEntities(id, type, idPattern, typePattern, q, mq, georel, geometry, coords, limit, offset, attrs, metadata, orderBy, options)

List Entities

Retrieves a list of entities that match different criteria by id, type, pattern matching (either id or type) and/or those which match a query or geographical query (see [Simple Query Language](#simple_query_language) and  [Geographical Queries](#geographical_queries)). A given entity has to match all the criteria to be retrieved (i.e., the criteria is combined in a logical AND way). Note that pattern matching query parameters are incompatible (i.e. mutually exclusive) with their corresponding exact matching parameters, i.e. &#x60;idPattern&#x60; with &#x60;id&#x60; and &#x60;typePattern&#x60; with &#x60;type&#x60;. The response payload is an array containing one object per matching entity. Each entity follows the JSON entity representation format (described in \&quot;JSON Entity Representation\&quot; section). Response code: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EntitiesApi;


EntitiesApi apiInstance = new EntitiesApi();
String id = "id_example"; // String | A comma-separated list of elements. Retrieve entities whose ID matches one of the elements in the list. Incompatible with `idPattern`.
String type = "type_example"; // String | comma-separated list of elements. Retrieve entities whose type matches one of the elements in the list. Incompatible with `typePattern`.
String idPattern = "idPattern_example"; // String | A correctly formated regular expression. Retrieve entities whose ID matches the regular expression. Incompatible with `id`.
String typePattern = "typePattern_example"; // String | A correctly formated regular expression. Retrieve entities whose type matches the regular expression. Incompatible with `type`.
String q = "q_example"; // String | A query expression, composed of a list of statements separated by `;`, i.e., q=statement1;statement2;statement3. See [Simple Query Language specification](#simple_query_language).
String mq = "mq_example"; // String | A query expression for attribute metadata, composed of a list of statements separated by `;`, i.e., mq=statement1;statement2;statement3. See [Simple Query Language specification](#simple_query_language).
String georel = "georel_example"; // String | Spatial relationship between matching entities and a reference shape. See [Geographical Queries](#geographical_queries).
String geometry = "geometry_example"; // String | Geografical area to which the query is restricted. See [Geographical Queries](#geographical_queries).
String coords = "coords_example"; // String | List of latitude-longitude pairs of coordinates separated by ';'. See [Geographical Queries](#geographical_queries).
Double limit = 3.4D; // Double | Limits the number of entities to be retrieved
Double offset = 3.4D; // Double | Establishes the offset from where entities are retrieved
String attrs = "attrs_example"; // String | Comma-separated list of attribute names whose data are to be included in the response. The attributes are retrieved in the order specified by this parameter. If this parameter is not included, the attributes are retrieved in arbitrary order. See \"Filtering out attributes and metadata\" section for more detail.
String metadata = "metadata_example"; // String | A list of metadata names to include in the response. See \"Filtering out attributes and metadata\" section for more detail.
String orderBy = "orderBy_example"; // String | Criteria for ordering results. See \"Ordering Results\" section for details.
String options = "options_example"; // String | Options dictionary
try {
    List<ListEntitiesResponse> result = apiInstance.listEntities(id, type, idPattern, typePattern, q, mq, georel, geometry, coords, limit, offset, attrs, metadata, orderBy, options);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EntitiesApi#listEntities");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| A comma-separated list of elements. Retrieve entities whose ID matches one of the elements in the list. Incompatible with &#x60;idPattern&#x60;. | [optional]
 **type** | **String**| comma-separated list of elements. Retrieve entities whose type matches one of the elements in the list. Incompatible with &#x60;typePattern&#x60;. | [optional]
 **idPattern** | **String**| A correctly formated regular expression. Retrieve entities whose ID matches the regular expression. Incompatible with &#x60;id&#x60;. | [optional]
 **typePattern** | **String**| A correctly formated regular expression. Retrieve entities whose type matches the regular expression. Incompatible with &#x60;type&#x60;. | [optional]
 **q** | **String**| A query expression, composed of a list of statements separated by &#x60;;&#x60;, i.e., q&#x3D;statement1;statement2;statement3. See [Simple Query Language specification](#simple_query_language). | [optional]
 **mq** | **String**| A query expression for attribute metadata, composed of a list of statements separated by &#x60;;&#x60;, i.e., mq&#x3D;statement1;statement2;statement3. See [Simple Query Language specification](#simple_query_language). | [optional]
 **georel** | **String**| Spatial relationship between matching entities and a reference shape. See [Geographical Queries](#geographical_queries). | [optional]
 **geometry** | **String**| Geografical area to which the query is restricted. See [Geographical Queries](#geographical_queries). | [optional]
 **coords** | **String**| List of latitude-longitude pairs of coordinates separated by &#39;;&#39;. See [Geographical Queries](#geographical_queries). | [optional]
 **limit** | **Double**| Limits the number of entities to be retrieved | [optional]
 **offset** | **Double**| Establishes the offset from where entities are retrieved | [optional]
 **attrs** | **String**| Comma-separated list of attribute names whose data are to be included in the response. The attributes are retrieved in the order specified by this parameter. If this parameter is not included, the attributes are retrieved in arbitrary order. See \&quot;Filtering out attributes and metadata\&quot; section for more detail. | [optional]
 **metadata** | **String**| A list of metadata names to include in the response. See \&quot;Filtering out attributes and metadata\&quot; section for more detail. | [optional]
 **orderBy** | **String**| Criteria for ordering results. See \&quot;Ordering Results\&quot; section for details. | [optional]
 **options** | **String**| Options dictionary | [optional] [enum: count, keyValues, values, unique]

### Return type

[**List&lt;ListEntitiesResponse&gt;**](ListEntitiesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeEntity"></a>
# **removeEntity**
> removeEntity(entityId, type)

Remove Entity

Delete the entity. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EntitiesApi;


EntitiesApi apiInstance = new EntitiesApi();
String entityId = "entityId_example"; // String | Id of the entity to be deleted
String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
try {
    apiInstance.removeEntity(entityId, type);
} catch (ApiException e) {
    System.err.println("Exception when calling EntitiesApi#removeEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityId** | **String**| Id of the entity to be deleted |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="replaceAllEntityAttributes"></a>
# **replaceAllEntityAttributes**
> replaceAllEntityAttributes(entityId, contentType, body, type, options)

Replace all entity attributes

The request payload is an object representing the new entity attributes. The object follows the JSON entity representation format (described in a \&quot;JSON Entity Representation\&quot; above), except that &#x60;id&#x60; and &#x60;type&#x60; are not allowed. The attributes previously existing in the entity are removed and replaced by the ones in the request. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EntitiesApi;


EntitiesApi apiInstance = new EntitiesApi();
String entityId = "entityId_example"; // String | Id of the entity in question.
String contentType = "contentType_example"; // String | 
ReplaceAllEntityAttributesRequest body = new ReplaceAllEntityAttributesRequest(); // ReplaceAllEntityAttributesRequest | 
String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
String options = "options_example"; // String | Operations options
try {
    apiInstance.replaceAllEntityAttributes(entityId, contentType, body, type, options);
} catch (ApiException e) {
    System.err.println("Exception when calling EntitiesApi#replaceAllEntityAttributes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityId** | **String**| Id of the entity in question. |
 **contentType** | **String**|  |
 **body** | [**ReplaceAllEntityAttributesRequest**](ReplaceAllEntityAttributesRequest.md)|  |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]
 **options** | **String**| Operations options | [optional] [enum: keyValues]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveEntity"></a>
# **retrieveEntity**
> RetrieveEntityResponse retrieveEntity(entityId, type, attrs, metadata, options)

Retrieve Entity

The response is an object representing the entity identified by the ID. The object follows the JSON entity representation format (described in \&quot;JSON Entity Representation\&quot; section). This operation must return one entity element only, but there may be more than one entity with the same ID (e.g. entities with same ID but different types). In such case, an error message is returned, with the HTTP status code set to 409 Conflict. Response: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EntitiesApi;


EntitiesApi apiInstance = new EntitiesApi();
String entityId = "entityId_example"; // String | Id of the entity to be retrieved
String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
String attrs = "attrs_example"; // String | Comma-separated list of attribute names whose data must be included in the response. The attributes are retrieved in the order specified by this parameter. See \"Filtering out attributes and metadata\" section for more detail. If this parameter is not included, the attributes are retrieved in arbitrary order, and all the attributes of the entity are included in the response.
String metadata = "metadata_example"; // String | A list of metadata names to include in the response. See \"Filtering out attributes and metadata\" section for more detail.
String options = "options_example"; // String | Options dictionary
try {
    RetrieveEntityResponse result = apiInstance.retrieveEntity(entityId, type, attrs, metadata, options);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EntitiesApi#retrieveEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityId** | **String**| Id of the entity to be retrieved |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]
 **attrs** | **String**| Comma-separated list of attribute names whose data must be included in the response. The attributes are retrieved in the order specified by this parameter. See \&quot;Filtering out attributes and metadata\&quot; section for more detail. If this parameter is not included, the attributes are retrieved in arbitrary order, and all the attributes of the entity are included in the response. | [optional]
 **metadata** | **String**| A list of metadata names to include in the response. See \&quot;Filtering out attributes and metadata\&quot; section for more detail. | [optional]
 **options** | **String**| Options dictionary | [optional] [enum: keyValues, values, unique]

### Return type

[**RetrieveEntityResponse**](RetrieveEntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveEntityAttributes"></a>
# **retrieveEntityAttributes**
> RetrieveEntityAttributesResponse retrieveEntityAttributes(entityId, type, attrs, metadata, options)

Retrieve Entity Attributes

This request is similar to retreiving the whole entity, however this one omits the &#x60;id&#x60; and &#x60;type&#x60; fields. Just like the general request of getting an entire entity, this operation must return only one entity element. If more than one entity with the same ID is found (e.g. entities with same ID but different type), an error message is returned, with the HTTP status code set to 409 Conflict. Response: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EntitiesApi;


EntitiesApi apiInstance = new EntitiesApi();
String entityId = "entityId_example"; // String | Id of the entity to be retrieved
String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
String attrs = "attrs_example"; // String | Comma-separated list of attribute names whose data are to be included in the response. The attributes are retrieved in the order specified by this parameter. If this parameter is not included, the attributes are retrieved in arbitrary order, and all the attributes of the entity are included in the response. See \"Filtering out attributes and metadata\" section for more detail.
String metadata = "metadata_example"; // String | A list of metadata names to include in the response. See \"Filtering out attributes and metadata\" section for more detail.
String options = "options_example"; // String | Options dictionary
try {
    RetrieveEntityAttributesResponse result = apiInstance.retrieveEntityAttributes(entityId, type, attrs, metadata, options);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EntitiesApi#retrieveEntityAttributes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityId** | **String**| Id of the entity to be retrieved |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]
 **attrs** | **String**| Comma-separated list of attribute names whose data are to be included in the response. The attributes are retrieved in the order specified by this parameter. If this parameter is not included, the attributes are retrieved in arbitrary order, and all the attributes of the entity are included in the response. See \&quot;Filtering out attributes and metadata\&quot; section for more detail. | [optional]
 **metadata** | **String**| A list of metadata names to include in the response. See \&quot;Filtering out attributes and metadata\&quot; section for more detail. | [optional]
 **options** | **String**| Options dictionary | [optional] [enum: keyValues, values, unique]

### Return type

[**RetrieveEntityAttributesResponse**](RetrieveEntityAttributesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateExistingEntityAttributes"></a>
# **updateExistingEntityAttributes**
> updateExistingEntityAttributes(entityId, contentType, body, type, options)

Update Existing Entity Attributes

The request payload is an object representing the attributes to update. The object follows the JSON entity representation format (described in \&quot;JSON Entity Representation\&quot; section), except that &#x60;id&#x60; and &#x60;type&#x60; are not allowed. The entity attributes are updated with the ones in the payload. In addition to that, if one or more attributes in the payload doesn&#39;t exist in the entity, an error is returned. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EntitiesApi;


EntitiesApi apiInstance = new EntitiesApi();
String entityId = "entityId_example"; // String | Id of the entity to be updated
String contentType = "contentType_example"; // String | 
UpdateExistingEntityAttributesRequest body = new UpdateExistingEntityAttributesRequest(); // UpdateExistingEntityAttributesRequest | 
String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
String options = "options_example"; // String | Operations options
try {
    apiInstance.updateExistingEntityAttributes(entityId, contentType, body, type, options);
} catch (ApiException e) {
    System.err.println("Exception when calling EntitiesApi#updateExistingEntityAttributes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityId** | **String**| Id of the entity to be updated |
 **contentType** | **String**|  |
 **body** | [**UpdateExistingEntityAttributesRequest**](UpdateExistingEntityAttributesRequest.md)|  |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]
 **options** | **String**| Operations options | [optional] [enum: keyValues]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateOrAppendEntityAttributes"></a>
# **updateOrAppendEntityAttributes**
> updateOrAppendEntityAttributes(entityId, contentType, body, type, options)

Update or Append Entity Attributes

The request payload is an object representing the attributes to append or update. The object follows the JSON entity representation format (described in \&quot;JSON Entity Representation\&quot; section), except that &#x60;id&#x60; and &#x60;type&#x60; are not allowed. The entity attributes are updated with the ones in the payload, depending on whether the &#x60;append&#x60; operation option is used or not. * If &#x60;append&#x60; is not used: the entity attributes are updated (if they previously exist) or appended   (if they don&#39;t previously exist) with the ones in the payload. * If &#x60;append&#x60; is used (i.e. strict append semantics): all the attributes in the payload not   previously existing in the entity are appended. In addition to that, in case some of the   attributes in the payload already exist in the entity, an error is returned. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EntitiesApi;


EntitiesApi apiInstance = new EntitiesApi();
String entityId = "entityId_example"; // String | Entity id to be updated
String contentType = "contentType_example"; // String | 
UpdateOrAppendEntityAttributesRequest body = new UpdateOrAppendEntityAttributesRequest(); // UpdateOrAppendEntityAttributesRequest | 
String type = "type_example"; // String | Entity type, to avoid ambiguity in case there are several entities with the same entity id.
String options = "options_example"; // String | Operations options
try {
    apiInstance.updateOrAppendEntityAttributes(entityId, contentType, body, type, options);
} catch (ApiException e) {
    System.err.println("Exception when calling EntitiesApi#updateOrAppendEntityAttributes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityId** | **String**| Entity id to be updated |
 **contentType** | **String**|  |
 **body** | [**UpdateOrAppendEntityAttributesRequest**](UpdateOrAppendEntityAttributesRequest.md)|  |
 **type** | **String**| Entity type, to avoid ambiguity in case there are several entities with the same entity id. | [optional]
 **options** | **String**| Operations options | [optional] [enum: append, keyValues]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

