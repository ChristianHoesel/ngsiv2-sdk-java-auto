# Registrations

A Context Registration allows to bind external context information sources so that they can
play the role of providers
of certain subsets (entities, attributes) of the context information space, including those located
at specific geographical areas.

A NGSIv2 server implementation may implement query and/or update forwarding to context information sources. In
particular, some of the following forwarding mechanisms could be implemented (not exahustive list):

* Legacy forwarding (based on NGSIv1 operations)

* NGSI Context Source Forwarding Specification

Please check the corresponding specification in order to get the details.

A context registration is represented by a JSON object with the following fields:

+ `id` : Unique identifier assigned to the registration. Automatically generated at creation time.

+ `description` : Description given to this registration. Optional.

+ `provider` : Object that describes the context source registered. Mandatory.

+ `dataProvided` : Object that describes the data provided by this source. Mandatory.

+ `status`: Enumerated field which captures the current status of this registration:
  Either `active` (for active registrations) or `inactive` (for inactive registrations).
  If this field is not provided at registration creation time, new registrations are created with
  the `active` status, which may be changed by clients afterwards. For expired registrations, this
  attribute is set to `expired` (no matter if the client updates it to `active`/`inactive`).
  Also, for registrations experiencing problems with forwarding operations, the status is set to `failed`.
  As soon as the forwarding operations start working again, the status is changed back to `active`.

+ `expires` : Registration expiration date in ISO8601 format. Permanent registrations must omit this field.

+ `forwardingInformation`: Information related to the forwarding operations made against the provider.
  Automatically provided by the implementation, in the case such implementation supports forwarding capabilities.

The `provider` field contains the following subfields:

+ `http` : It is used to convey parameters for providers that deliver information through the HTTP protocol.
  (Only protocol supported nowadays).
  It must contain a subfield named `url` with the URL that serves as the endpoint that offers the providing interface.
  The endpoint must *not* include the protocol
  specific part (for instance `/v2/entities`).

+ `supportedForwardingMode` : It is used to convey the forwarding mode supported by this context provider. By default `all`.
  Allowed values are:
  
  + `none` : This provider does not support request forwarding.
  + `query` : This provider only supports request forwarding to query data.
  + `update` : This provider only supports request forwarding to update data.
  + `all` : This provider supports both query and update forwarding requests. (Default value)

The `dataProvided` field contains the following subfields:

+ `entities`: A list of objects, each one composed of the following subfields:
  
  + `id` or `idPattern`: Id or pattern of the affected entities. Both cannot be used at the same
    time, but one of them must be present.
  + `type` or `typePattern`: Type or pattern of the affected entities. Both cannot be used at
    the same time. If omitted, it means "any entity type".

+ `attrs`: List of attributes to be provided (if not specified, all attributes).

+ `expression`: By means of a filtering expression, allows to express what is the scope of the data provided.
  Currently only geographical scopes are supported through the following subterms:
  
  + `georel` : Any of the geographical relationships as specified by the Geoqueries section of this specification.
  + `geometry` : Any of the supported geometries as specified by the Geoqueries section of this specification.
  + `coords` : String representation of coordinates as specified by the Geoqueries section of this specification.

The `forwardingInformation` field contains the following subfields:

+ `timesSent` (not editable, only present in GET operations): Number of request forwardings sent due to this registration.

+ `lastForwarding` (not editable, only present in GET operations): Last forwarding timestamp in ISO8601 format.

+ `lastFailure` (not editable, only present in GET operations): Last failure timestamp in ISO8601 format.
  Not present if registration has never had a problem with forwarding.

+ `lastSuccess` (not editable, only present in GET operations): Timestamp in ISO8601 format for last successful request forwarding.
  Not present if registration has never had a successful notification.

```java
RegistrationsController registrationsController = client.getRegistrationsController();
```

## Class Name

`RegistrationsController`

## Methods

* [List Registrations](../../doc/controllers/registrations.md#list-registrations)
* [Create Registration](../../doc/controllers/registrations.md#create-registration)
* [Retrieve Registration](../../doc/controllers/registrations.md#retrieve-registration)
* [Update Registration](../../doc/controllers/registrations.md#update-registration)
* [Delete Registration](../../doc/controllers/registrations.md#delete-registration)


# List Registrations

Lists all the context provider registrations present in the system.

```java
CompletableFuture<List<ListRegistrationsResponse>> listRegistrationsAsync(
    final Double limit,
    final Double offset,
    final Options8Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `limit` | `Double` | Query, Optional | Limit the number of registrations to be retrieved |
| `offset` | `Double` | Query, Optional | Skip a number of registrations |
| `options` | [`Options8Enum`](../../doc/models/options-8-enum.md) | Query, Optional | Options dictionary |

## Response Type

[`List<ListRegistrationsResponse>`](../../doc/models/list-registrations-response.md)

## Example Usage

```java
Double limit = 237.24;
Double offset = 110.2;

registrationsController.listRegistrationsAsync(limit, offset, null).thenAccept(result -> {
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
    "description": "Example Context Source",
    "dataProvided": {
      "entities": [
        {
          "id": "Bcn_Welt",
          "type": "Room"
        }
      ],
      "attrs": [
        "temperature"
      ]
    },
    "provider": {
      "http": {
        "url": "http://contextsource.example.org"
      },
      "supportedForwardingMode": "all"
    },
    "expires": "2017-10-31T12:00:00",
    "status": "active",
    "forwardingInformation": {
      "timesSent": 12,
      "lastForwarding": "2017-10-06T16:00:00.00Z",
      "lastSuccess": "2017-10-06T16:00:00.00Z",
      "lastFailure": "2017-10-05T16:00:00.00Z"
    }
  }
]
```


# Create Registration

Creates a new context provider registration. This is typically used for binding context sources
as providers of certain data.
The registration is represented by a JSON object as described at the beginning of this section.

Response:

* Successful operation uses 201 Created

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> createRegistrationAsync(
    final CreateRegistrationRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateRegistrationRequest`](../../doc/models/create-registration-request.md) | Body, Required | - |

## Response Type

`void`

## Example Usage

```java
CreateRegistrationRequest body = new CreateRegistrationRequest();
body.setDescription("Relative Humidity Context Source");
body.setDataProvided(new DataProvided());
body.getDataProvided().setEntities(new LinkedList<>());

Entity bodyDataProvidedEntities0 = new Entity();
bodyDataProvidedEntities0.setId("room2");
bodyDataProvidedEntities0.setType("Room");
body.getDataProvided().getEntities().add(bodyDataProvidedEntities0);

body.getDataProvided().setAttrs(new LinkedList<>());
body.getDataProvided().getAttrs().add("relativeHumidity");
body.setProvider(new Provider1());
body.getProvider().setHttp(new Http());
body.getProvider().getHttp().setUrl("http://localhost:1234");

registrationsController.createRegistrationAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Registration

The response is the registration represented by a JSON object as described at the beginning of this
section.

Response:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<RetrieveRegistrationResponse> retrieveRegistrationAsync(
    final String registrationId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `registrationId` | `String` | Template, Required | registration Id. |

## Response Type

[`RetrieveRegistrationResponse`](../../doc/models/retrieve-registration-response.md)

## Example Usage

```java
String registrationId = "abcdef";

registrationsController.retrieveRegistrationAsync(registrationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response *(as JSON)*

```json
{
  "id": "abcdefg",
  "description": "Example Context Source",
  "dataProvided": {
    "entities": [
      {
        "id": "Bcn_Welt",
        "type": "Room"
      }
    ],
    "attrs": [
      "temperature"
    ]
  },
  "provider": {
    "http": {
      "url": "http://contextsource.example.org"
    },
    "supportedForwardingMode": "all"
  },
  "expires": "2017-10-31T12:00:00",
  "status": "failed",
  "forwardingInformation": {
    "timesSent": 12,
    "lastForwarding": "2017-10-06T16:00:00.00Z",
    "lastFailure": "2017-10-06T16:00:00.00Z",
    "lastSuccess": "2017-10-05T18:25:00.00Z"
  }
}
```


# Update Registration

Only the fields included in the request are updated in the registration.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> updateRegistrationAsync(
    final String registrationId,
    final UpdateRegistrationRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `registrationId` | `String` | Template, Required | registration Id. |
| `body` | [`UpdateRegistrationRequest`](../../doc/models/update-registration-request.md) | Body, Required | - |

## Response Type

`void`

## Example Usage

```java
String registrationId = "abcdef";
UpdateRegistrationRequest body = new UpdateRegistrationRequest();
body.setExpires("2017-10-04T00:00:00");

registrationsController.updateRegistrationAsync(registrationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Registration

Cancels a context provider registration.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> deleteRegistrationAsync(
    final String registrationId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `registrationId` | `String` | Template, Required | registration Id. |

## Response Type

`void`

## Example Usage

```java
String registrationId = "abcdef";

registrationsController.deleteRegistrationAsync(registrationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

