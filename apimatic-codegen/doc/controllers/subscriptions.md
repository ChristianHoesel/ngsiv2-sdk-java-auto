# Subscriptions

A subscription is represented by a JSON object with the following fields:

+ `id`: Subscription unique identifier. Automatically created at creation time.

+ `description` (optional): A free text used by the client to describe the subscription.

+ `subject`: An object that describes the subject of the subscription.

+ `notification`: An object that describes the notification to send when the subscription is
  triggered.

+ `expires`: Subscription expiration date in ISO8601 format. Permanent subscriptions must omit
  this field.

+ `status`: Either `active` (for active subscriptions) or `inactive` (for inactive subscriptions).
  If this field is not provided at subscription creation time, new subscriptions are created with
  the `active` status, which can be changed by clients afterwards. For expired subscriptions, this
  attribute is set to `expired` (no matter if the client updates it to `active`/`inactive`).
  Also, for subscriptions experiencing problems with notifications, the status is set to `failed`.
  As soon as the notifications start working again, the status is changed back to `active`.

+ `throttling`: Minimal period of time in seconds which must elapse between two consecutive
  notifications. It is optional.

A `subject` contains the following subfields:

+ `entities`: A list of objects, each one composed of the following subfields:
  
  + `id` or `idPattern`: Id or pattern of the affected entities. Both cannot be used at the same
    time, but one of them must be present.
  + `type` or `typePattern`: Type or type pattern of the affected entities. Both cannot be used at
    the same time. If omitted, it means "any entity type".

+ `condition`: Condition to trigger notifications. This field is optional and it may contain two
  properties, both optional:
  
  + `attrs`: array of attribute names
  + `expression`: an expression composed of `q`, `mq`, `georel`, `geometry` and `coords` (see "List
    entities" operation above about this field).

A `notification` object contains the following subfields:

+ `attrs` or `exceptAttrs` (both cannot be used at the same time):
  
  + `attrs`: List of attributes to be included in notification messages. It also defines the
    order in which attributes must appear in notifications when `attrsFormat` `value` is used
    (see "Notification Messages" section). An empty list means that all attributes are to be
    included in notifications. See "Filtering out attributes and metadata" section for more detail.
  + `exceptAttrs`: List of attributes to be excluded from the notification message, i.e.
    a notification message includes all entity attributes except the ones listed in this field.
  + If neither `attrs` nor `exceptAttrs` is specified, all attributes are included in
    notifications.

+ `http` or `httpCustom` (one of them must be present, but not both at the same time): It is used
  to convey parameters for notifications delivered through the HTTP protocol.

+ `attrsFormat` (optional): specifies how the entities are represented in notifications.
  Accepted values are `normalized` (default), `keyValues` or `values`.
  If `attrsFormat` takes any value different
  than those, an error is raised. See detail in "Notification Messages" section.

+ `metadata` (optional): List of metadata to be included in notification messages.
  See "Filtering out attributes and metadata" section for more detail.

+ `timesSent` (not editable, only present in GET operations): Number of notifications sent due to
  this subscription.

+ `lastNotification` (not editable, only present in GET operations): Last notification timestamp in ISO8601 format.

+ `lastFailure` (not editable, only present in GET operations): Last failure timestamp in ISO8601 format.
  Not present if subscription has never had a problem with notifications.

+ `lastSuccess` (not editable, only present in GET operations): Timestamp in ISO8601 format for last successful notification.
  Not present if subscription has never had a successful notification.

An `http` object contains the following subfields:

+ `url` : URL referencing the service to be invoked when a notification is generated. An NGSIv2
  compliant server must support the `http` URL schema. Other schemas could also be supported.

An `httpCustom` object contains the following subfields.

+ `url`: same as in `http` above.

+ `headers` (optional): a key-map of HTTP headers that are included in notification messages.

+ `qs` (optional): a key-map of URL query parameters that are included in notification messages.

+ `method` (optional): the method to use when sending the notification (default is POST).
  Only valid HTTP methods are allowed.
  On specifying an invalid HTTP method, a 400 Bad Request error is returned.

+ `payload` (optional): the payload to be used in notifications.
  If omitted, the default payload (see "Notification Messages" sections) is used.

If `httpCustom` is used, then the considerations described in "Custom Notifications" section apply.

Notification rules are as follow:

* If `attrs` and `expression` are used, a notification is sent whenever one of the attributes in
  the `attrs` list changes and at the same time `expression` matches.

* If `attrs` is used and `expression` is not used, a notification is sent whenever any of the
  attributes in the `attrs` list changes.

* If `attrs` is not used and `expression` is used, a notification is sent whenever any of the
  attributes of the entity changes and at the same time `expression` matches.

* If neither `attrs` nor `expression` are used, a notification is sent whenever any of the
  attributes of the entity changes.

```java
SubscriptionsController subscriptionsController = client.getSubscriptionsController();
```

## Class Name

`SubscriptionsController`

## Methods

* [List Subscriptions](../../doc/controllers/subscriptions.md#list-subscriptions)
* [Create Subscription](../../doc/controllers/subscriptions.md#create-subscription)
* [Retrieve Subscription](../../doc/controllers/subscriptions.md#retrieve-subscription)
* [Update Subscription](../../doc/controllers/subscriptions.md#update-subscription)
* [Delete Subscription](../../doc/controllers/subscriptions.md#delete-subscription)


# List Subscriptions

Returns a list of all the subscriptions present in the system.

Response:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<List<ListSubscriptionsResponse>> listSubscriptionsAsync(
    final Double limit,
    final Double offset,
    final Options8Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `limit` | `Double` | Query, Optional | Limit the number of subscriptions to be retrieved |
| `offset` | `Double` | Query, Optional | Skip a number of subscriptions |
| `options` | [`Options8Enum`](../../doc/models/options-8-enum.md) | Query, Optional | Options dictionary |

## Response Type

[`List<ListSubscriptionsResponse>`](../../doc/models/list-subscriptions-response.md)

## Example Usage

```java
Double limit = 237.24;
Double offset = 110.2;

subscriptionsController.listSubscriptionsAsync(limit, offset, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response *(as JSON)*

```json
[
  {
    "id": "abcdefg",
    "description": "One subscription to rule them all",
    "subject": {
      "entities": [
        {
          "id": "Bcn_Welt",
          "type": "Room"
        }
      ],
      "condition": {
        "attrs": [
          "temperature "
        ],
        "expression": {
          "q": "temperature>40"
        }
      }
    },
    "notification": {
      "httpCustom": {
        "url": "http://localhost:1234",
        "headers": {
          "X-MyHeader": "foo"
        },
        "qs": {
          "authToken": "bar"
        }
      },
      "attrsFormat": "keyValues",
      "attrs": [
        "temperature",
        "humidity"
      ],
      "timesSent": 12,
      "lastNotification": "2015-10-05T16:00:00.00Z",
      "lastFailure": "2015-10-06T16:00:00.00Z"
    },
    "expires": "2016-04-05T14:00:00.00Z",
    "status": "failed",
    "throttling": 5
  }
]
```


# Create Subscription

Creates a new subscription.
The subscription is represented by a JSON object as described at the beginning of this section.

Response:

* Successful operation uses 201 Created

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> createSubscriptionAsync(
    final CreateSubscriptionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateSubscriptionRequest`](../../doc/models/create-subscription-request.md) | Body, Required | - |

## Response Type

`void`

## Example Usage

```java
CreateSubscriptionRequest body = new CreateSubscriptionRequest();
body.setDescription("One subscription to rule them all");
body.setSubject(new Subject1());
body.getSubject().setEntities(new LinkedList<>());

Entity1 bodySubjectEntities0 = new Entity1();
bodySubjectEntities0.setIdPattern(".*");
bodySubjectEntities0.setType("Room");
body.getSubject().getEntities().add(bodySubjectEntities0);

body.getSubject().setCondition(new Condition());
body.getSubject().getCondition().setAttrs(new LinkedList<>());
body.getSubject().getCondition().getAttrs().add("temperature");
body.getSubject().getCondition().setExpression(new Expression());
body.getSubject().getCondition().getExpression().setQ("temperature>40");
body.setNotification(new Notification1());
body.getNotification().setHttp(new Http());
body.getNotification().getHttp().setUrl("http://localhost:1234");
body.getNotification().setAttrs(new LinkedList<>());
body.getNotification().getAttrs().add("temperature");
body.getNotification().getAttrs().add("humidity");
body.setExpires("2016-04-05T14:00:00.00Z");
body.setThrottling(5);

subscriptionsController.createSubscriptionAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Subscription

The response is the subscription represented by a JSON object as described at the beginning of this
section.

Response:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<DynamicResponse> retrieveSubscriptionAsync(
    final String subscriptionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | subscription Id. |

## Response Type

`DynamicResponse`

## Example Usage

```java
String subscriptionId = "abcdef";

subscriptionsController.retrieveSubscriptionAsync(subscriptionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Subscription

Only the fields included in the request are updated in the subscription.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> updateSubscriptionAsync(
    final String subscriptionId,
    final UpdateSubscriptionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | subscription Id. |
| `body` | [`UpdateSubscriptionRequest`](../../doc/models/update-subscription-request.md) | Body, Required | - |

## Response Type

`void`

## Example Usage

```java
String subscriptionId = "abcdef";
UpdateSubscriptionRequest body = new UpdateSubscriptionRequest();
body.setExpires("2016-04-05T14:00:00.00Z");

subscriptionsController.updateSubscriptionAsync(subscriptionId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Subscription

Cancels subscription.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> deleteSubscriptionAsync(
    final String subscriptionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | subscription Id. |

## Response Type

`void`

## Example Usage

```java
String subscriptionId = "abcdef";

subscriptionsController.deleteSubscriptionAsync(subscriptionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

