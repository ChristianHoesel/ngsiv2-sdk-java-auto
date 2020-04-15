# RegistrationsApi

All URIs are relative to *http://orion.lab.fiware.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRegistration**](RegistrationsApi.md#createRegistration) | **POST** /v2/registrations | Create Registration
[**deleteRegistration**](RegistrationsApi.md#deleteRegistration) | **DELETE** /v2/registrations/{registrationId} | Delete Registration
[**listRegistrations**](RegistrationsApi.md#listRegistrations) | **GET** /v2/registrations | List Registrations
[**retrieveRegistration**](RegistrationsApi.md#retrieveRegistration) | **GET** /v2/registrations/{registrationId} | Retrieve Registration
[**updateRegistration**](RegistrationsApi.md#updateRegistration) | **PATCH** /v2/registrations/{registrationId} | Update Registration


<a name="createRegistration"></a>
# **createRegistration**
> createRegistration(contentType, body)

Create Registration

Creates a new context provider registration. This is typically used for binding context sources as providers of certain data. The registration is represented by a JSON object as described at the beginning of this section. Response: * Successful operation uses 201 Created * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RegistrationsApi;


RegistrationsApi apiInstance = new RegistrationsApi();
String contentType = "contentType_example"; // String | 
CreateRegistrationRequest body = new CreateRegistrationRequest(); // CreateRegistrationRequest | 
try {
    apiInstance.createRegistration(contentType, body);
} catch (ApiException e) {
    System.err.println("Exception when calling RegistrationsApi#createRegistration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  |
 **body** | [**CreateRegistrationRequest**](CreateRegistrationRequest.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteRegistration"></a>
# **deleteRegistration**
> deleteRegistration(registrationId)

Delete Registration

Cancels a context provider registration. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RegistrationsApi;


RegistrationsApi apiInstance = new RegistrationsApi();
String registrationId = "registrationId_example"; // String | registration Id.
try {
    apiInstance.deleteRegistration(registrationId);
} catch (ApiException e) {
    System.err.println("Exception when calling RegistrationsApi#deleteRegistration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registrationId** | **String**| registration Id. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listRegistrations"></a>
# **listRegistrations**
> List&lt;ListRegistrationsResponse&gt; listRegistrations(limit, offset, options)

List Registrations

Lists all the context provider registrations present in the system.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RegistrationsApi;


RegistrationsApi apiInstance = new RegistrationsApi();
Double limit = 3.4D; // Double | Limit the number of registrations to be retrieved
Double offset = 3.4D; // Double | Skip a number of registrations
String options = "options_example"; // String | Options dictionary
try {
    List<ListRegistrationsResponse> result = apiInstance.listRegistrations(limit, offset, options);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RegistrationsApi#listRegistrations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Double**| Limit the number of registrations to be retrieved | [optional]
 **offset** | **Double**| Skip a number of registrations | [optional]
 **options** | **String**| Options dictionary | [optional] [enum: count]

### Return type

[**List&lt;ListRegistrationsResponse&gt;**](ListRegistrationsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveRegistration"></a>
# **retrieveRegistration**
> RetrieveRegistrationResponse retrieveRegistration(registrationId)

Retrieve Registration

The response is the registration represented by a JSON object as described at the beginning of this section. Response: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RegistrationsApi;


RegistrationsApi apiInstance = new RegistrationsApi();
String registrationId = "registrationId_example"; // String | registration Id.
try {
    RetrieveRegistrationResponse result = apiInstance.retrieveRegistration(registrationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RegistrationsApi#retrieveRegistration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registrationId** | **String**| registration Id. |

### Return type

[**RetrieveRegistrationResponse**](RetrieveRegistrationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateRegistration"></a>
# **updateRegistration**
> updateRegistration(registrationId, contentType, body)

Update Registration

Only the fields included in the request are updated in the registration. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RegistrationsApi;


RegistrationsApi apiInstance = new RegistrationsApi();
String registrationId = "registrationId_example"; // String | registration Id.
String contentType = "contentType_example"; // String | 
UpdateRegistrationRequest body = new UpdateRegistrationRequest(); // UpdateRegistrationRequest | 
try {
    apiInstance.updateRegistration(registrationId, contentType, body);
} catch (ApiException e) {
    System.err.println("Exception when calling RegistrationsApi#updateRegistration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registrationId** | **String**| registration Id. |
 **contentType** | **String**|  |
 **body** | [**UpdateRegistrationRequest**](UpdateRegistrationRequest.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

