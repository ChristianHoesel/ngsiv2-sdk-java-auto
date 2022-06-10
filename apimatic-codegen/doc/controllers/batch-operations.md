# Batch Operations

```java
BatchOperationsController batchOperationsController = client.getBatchOperationsController();
```

## Class Name

`BatchOperationsController`

## Methods

* [Update](../../doc/controllers/batch-operations.md#update)
* [Query](../../doc/controllers/batch-operations.md#query)
* [Notify](../../doc/controllers/batch-operations.md#notify)


# Update

This operation allows to create, update and/or delete several entities in a single batch operation.
The payload is an object with two properties:

+ `actionType`, to specify the kind of update action to do: either `append`, `appendStrict`, `update`,
  `delete`, or `replace`.

+ `entities`, an array of entities, each entity specified using the JSON entity representation format
  (described in the section "JSON Entity Representation").

This operation is split in as many individual operations as entities in the `entities` vector, so
the `actionType` is executed for each one of them. Depending on the `actionType`, a mapping with
regular non-batch operations can be done:

* `append`: maps to `POST /v2/entities` (if the entity does not already exist) or `POST /v2/entities/<id>/attrs`
  (if the entity already exists).

* `appendStrict`: maps to `POST /v2/entities` (if the entity does not already exist) or
  `POST /v2/entities/<id>/attrs?options=append` (if the entity already exists).

* `update`: maps to `PATCH /v2/entities/<id>/attrs`.

* `delete`: maps to `DELETE /v2/entities/<id>/attrs/<attrName>` on every attribute included in the entity or
  to `DELETE /v2/entities/<id>` if no attribute were included in the entity.

* `replace`: maps to `PUT /v2/entities/<id>/attrs`.

Response:

* Successful operation uses 204 No Content.

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> updateAsync(
    final UpdateRequest body,
    final Options5Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpdateRequest`](../../doc/models/update-request.md) | Body, Required | - |
| `options` | [`Options5Enum`](../../doc/models/options-5-enum.md) | Query, Optional | Options dictionary |

## Response Type

`void`

## Example Usage

```java
UpdateRequest body = new UpdateRequest();
body.setActionType("append");
body.setEntities(new LinkedList<>());

Entity5 bodyEntities0 = new Entity5();
bodyEntities0.setType("Room");
bodyEntities0.setId("Bcn-Welt");
bodyEntities0.setTemperature(new Temperature1());
bodyEntities0.getTemperature().setValue(21.7);
bodyEntities0.setHumidity(new Humidity());
bodyEntities0.getHumidity().setValue(60);
body.getEntities().add(bodyEntities0);

Entity5 bodyEntities1 = new Entity5();
bodyEntities1.setType("Room");
bodyEntities1.setId("Mad_Aud");
bodyEntities1.setTemperature(new Temperature1());
bodyEntities1.getTemperature().setValue(22.9);
bodyEntities1.setHumidity(new Humidity());
bodyEntities1.getHumidity().setValue(85);
body.getEntities().add(bodyEntities1);


batchOperationsController.updateAsync(body, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Query

The response payload is an Array containing one object per matching entity, or an empty array `[]` if
no entities are found. The entities follow the JSON entity representation format
(described in the section "JSON Entity Representation").

The payload may contain the following elements (all of them optional):

+ `entities`: a list of entites to search for. Each element is represented by a JSON object with the
  following elements:
  
  + `id` or `idPattern`: Id or pattern of the affected entities. Both cannot be used at the same
    time, but one of them must be present.
  + `type` or `typePattern`: Type or type pattern of the entities to search for. Both cannot be used at
    the same time. If omitted, it means "any entity type".

+ `attrs`: List of attributes to be provided (if not specified, all attributes).

+ `expression`: an expression composed of `q`, `mq`, `georel`, `geometry` and `coords` (see "List
  entities" operation above about this field).

+ `metadata`: a list of metadata names to include in the response.
  See "Filtering out attributes and metadata" section for more detail.

Response code:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<List<QueryResponse>> queryAsync(
    final QueryRequest body,
    final Double limit,
    final Double offset,
    final String orderBy,
    final OptionsEnum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`QueryRequest`](../../doc/models/query-request.md) | Body, Required | - |
| `limit` | `Double` | Query, Optional | Limit the number of entities to be retrieved. |
| `offset` | `Double` | Query, Optional | Skip a number of records. |
| `orderBy` | `String` | Query, Optional | Criteria for ordering results.<br>See "Ordering Results" section for details. |
| `options` | [`OptionsEnum`](../../doc/models/options-enum.md) | Query, Optional | Options dictionary |

## Response Type

[`List<QueryResponse>`](../../doc/models/query-response.md)

## Example Usage

```java
QueryRequest body = new QueryRequest();
body.setEntities(new LinkedList<>());

Entity6 bodyEntities0 = new Entity6();
bodyEntities0.setType("Room");
bodyEntities0.setIdPattern(".*");
body.getEntities().add(bodyEntities0);

Entity6 bodyEntities1 = new Entity6();
bodyEntities1.setType("P-9873-K");
bodyEntities1.setId("Car");
body.getEntities().add(bodyEntities1);

body.setAttrs(new LinkedList<>());
body.getAttrs().add("temperature");
body.getAttrs().add("humidity");
body.setExpression(new Expression());
body.getExpression().setQ("temperature>20");
body.setMetadata(new LinkedList<>());
body.getMetadata().add("accuracy");
body.getMetadata().add("timestamp");
Double limit = 237.24;
Double offset = 110.2;
String orderBy = "temperature,!speed";

batchOperationsController.queryAsync(body, limit, offset, orderBy, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Notify

This operation is intended to consume a notification payload so that all the entity data included by such notification is persisted, overwriting if necessary.
This operation is useful when one NGSIv2 endpoint is subscribed to another NGSIv2 endpoint (federation scenarios).
The request payload must be an NGSIv2 notification payload.
The behaviour must be exactly the same as `POST /v2/op/update` with `actionType` equal to `append`.

Response code:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> notifyAsync(
    final NotifyRequest body,
    final Options5Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`NotifyRequest`](../../doc/models/notify-request.md) | Body, Required | - |
| `options` | [`Options5Enum`](../../doc/models/options-5-enum.md) | Query, Optional | Options dictionary |

## Response Type

`void`

## Example Usage

```java
NotifyRequest body = new NotifyRequest();
body.setSubscriptionId("5aeb0ee97d4ef10a12a0262f");
body.setData(new LinkedList<>());

Datum bodyData0 = new Datum();
bodyData0.setType("Room");
bodyData0.setId("DC_S1-D41");
bodyData0.setTemperature(new Temperature3());
bodyData0.getTemperature().setValue(35.6);
bodyData0.getTemperature().setType("Number");
body.getData().add(bodyData0);

Datum bodyData1 = new Datum();
bodyData1.setType("Room");
bodyData1.setId("Boe-Idearium");
bodyData1.setTemperature(new Temperature3());
bodyData1.getTemperature().setValue(22.5);
bodyData1.getTemperature().setType("Number");
body.getData().add(bodyData1);


batchOperationsController.notifyAsync(body, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

