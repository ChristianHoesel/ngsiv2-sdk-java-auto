# SubscriptionsApi

All URIs are relative to *http://orion.lab.fiware.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSubscription**](SubscriptionsApi.md#createSubscription) | **POST** /v2/subscriptions | Create Subscription
[**deleteSubscription**](SubscriptionsApi.md#deleteSubscription) | **DELETE** /v2/subscriptions/{subscriptionId} | Delete subscription
[**listSubscriptions**](SubscriptionsApi.md#listSubscriptions) | **GET** /v2/subscriptions | List Subscriptions
[**retrieveSubscription**](SubscriptionsApi.md#retrieveSubscription) | **GET** /v2/subscriptions/{subscriptionId} | Retrieve Subscription
[**updateSubscription**](SubscriptionsApi.md#updateSubscription) | **PATCH** /v2/subscriptions/{subscriptionId} | Update Subscription


<a name="createSubscription"></a>
# **createSubscription**
> createSubscription(contentType, body)

Create Subscription

Creates a new subscription. The subscription is represented by a JSON object as described at the beginning of this section. Response: * Successful operation uses 201 Created * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String contentType = "contentType_example"; // String | 
CreateSubscriptionRequest body = new CreateSubscriptionRequest(); // CreateSubscriptionRequest | 
try {
    apiInstance.createSubscription(contentType, body);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#createSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  |
 **body** | [**CreateSubscriptionRequest**](CreateSubscriptionRequest.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteSubscription"></a>
# **deleteSubscription**
> deleteSubscription(subscriptionId)

Delete subscription

Cancels subscription. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String subscriptionId = "subscriptionId_example"; // String | subscription Id.
try {
    apiInstance.deleteSubscription(subscriptionId);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#deleteSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionId** | **String**| subscription Id. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listSubscriptions"></a>
# **listSubscriptions**
> List&lt;ListSubscriptionsResponse&gt; listSubscriptions(limit, offset, options)

List Subscriptions

Returns a list of all the subscriptions present in the system. Response: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
Double limit = 3.4D; // Double | Limit the number of subscriptions to be retrieved
Double offset = 3.4D; // Double | Skip a number of subscriptions
String options = "options_example"; // String | Options dictionary
try {
    List<ListSubscriptionsResponse> result = apiInstance.listSubscriptions(limit, offset, options);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#listSubscriptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Double**| Limit the number of subscriptions to be retrieved | [optional]
 **offset** | **Double**| Skip a number of subscriptions | [optional]
 **options** | **String**| Options dictionary | [optional] [enum: count]

### Return type

[**List&lt;ListSubscriptionsResponse&gt;**](ListSubscriptionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveSubscription"></a>
# **retrieveSubscription**
> Object retrieveSubscription(subscriptionId)

Retrieve Subscription

The response is the subscription represented by a JSON object as described at the beginning of this section. Response: * Successful operation uses 200 OK * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String subscriptionId = "subscriptionId_example"; // String | subscription Id.
try {
    Object result = apiInstance.retrieveSubscription(subscriptionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#retrieveSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionId** | **String**| subscription Id. |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateSubscription"></a>
# **updateSubscription**
> updateSubscription(subscriptionId, contentType, body)

Update Subscription

Only the fields included in the request are updated in the subscription. Response: * Successful operation uses 204 No Content * Errors use a non-2xx and (optionally) an error payload. See subsection on \&quot;Error Responses\&quot; for   more details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String subscriptionId = "subscriptionId_example"; // String | subscription Id.
String contentType = "contentType_example"; // String | 
UpdateSubscriptionRequest body = new UpdateSubscriptionRequest(); // UpdateSubscriptionRequest | 
try {
    apiInstance.updateSubscription(subscriptionId, contentType, body);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#updateSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionId** | **String**| subscription Id. |
 **contentType** | **String**|  |
 **body** | [**UpdateSubscriptionRequest**](UpdateSubscriptionRequest.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

