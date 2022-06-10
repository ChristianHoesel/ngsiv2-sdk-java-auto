# Entities

```java
EntitiesController entitiesController = client.getEntitiesController();
```

## Class Name

`EntitiesController`

## Methods

* [List Entities](../../doc/controllers/entities.md#list-entities)
* [Create Entity](../../doc/controllers/entities.md#create-entity)
* [Retrieve Entity](../../doc/controllers/entities.md#retrieve-entity)
* [Retrieve Entity Attributes](../../doc/controllers/entities.md#retrieve-entity-attributes)
* [Update or Append Entity Attributes](../../doc/controllers/entities.md#update-or-append-entity-attributes)
* [Update Existing Entity Attributes](../../doc/controllers/entities.md#update-existing-entity-attributes)
* [Replace All Entity Attributes](../../doc/controllers/entities.md#replace-all-entity-attributes)
* [Remove Entity](../../doc/controllers/entities.md#remove-entity)


# List Entities

Retrieves a list of entities that match different criteria by id, type, pattern matching (either id or type)
and/or those which match a query or geographical query (see [Simple Query Language](#simple_query_language) and
[Geographical Queries](#geographical_queries)). A given entity has to match all the criteria to be retrieved
(i.e., the criteria is combined in a logical AND way). Note that pattern matching query parameters are incompatible
(i.e. mutually exclusive) with their corresponding exact matching parameters, i.e. `idPattern` with `id` and
`typePattern` with `type`.

The response payload is an array containing one object per matching entity. Each entity follows
the JSON entity representation format (described in "JSON Entity Representation" section).

Response code:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<List<ListEntitiesResponse>> listEntitiesAsync(
    final String id,
    final String type,
    final String idPattern,
    final String typePattern,
    final String q,
    final String mq,
    final String georel,
    final String geometry,
    final String coords,
    final Double limit,
    final Double offset,
    final String attrs,
    final String metadata,
    final String orderBy,
    final OptionsEnum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Query, Optional | A comma-separated list of elements.<br>Retrieve entities whose ID matches one of the elements in the list.<br>Incompatible with `idPattern`. |
| `type` | `String` | Query, Optional | comma-separated list of elements.<br>Retrieve entities whose type matches one of the elements in the list.<br>Incompatible with `typePattern`. |
| `idPattern` | `String` | Query, Optional | A correctly formated regular expression.<br>Retrieve entities whose ID matches the regular expression. Incompatible with `id`. |
| `typePattern` | `String` | Query, Optional | A correctly formated regular expression.<br>Retrieve entities whose type matches the regular expression. Incompatible with `type`. |
| `q` | `String` | Query, Optional | A query expression, composed of a list of statements<br>separated by `;`, i.e., q=statement1;statement2;statement3.<br>See [Simple Query Language specification](#simple_query_language). |
| `mq` | `String` | Query, Optional | A query expression for attribute metadata,<br>composed of a list of statements separated by `;`, i.e., mq=statement1;statement2;statement3.<br>See [Simple Query Language specification](#simple_query_language). |
| `georel` | `String` | Query, Optional | Spatial relationship between matching entities and a<br>reference shape. See [Geographical Queries](#geographical_queries). |
| `geometry` | `String` | Query, Optional | Geografical area to which the query is restricted.<br>See [Geographical Queries](#geographical_queries). |
| `coords` | `String` | Query, Optional | List of latitude-longitude<br>pairs of coordinates separated by ';'. See [Geographical Queries](#geographical_queries). |
| `limit` | `Double` | Query, Optional | Limits the number of entities to be retrieved |
| `offset` | `Double` | Query, Optional | Establishes the offset from where entities are retrieved |
| `attrs` | `String` | Query, Optional | Comma-separated list of attribute names whose data<br>are to be included in the response.<br>The attributes are retrieved in the order specified by this parameter. If this parameter is<br>not included, the attributes are retrieved in arbitrary order.<br>See "Filtering out attributes and metadata" section for more detail. |
| `metadata` | `String` | Query, Optional | A list of metadata names to include in the response.<br>See "Filtering out attributes and metadata" section for more detail. |
| `orderBy` | `String` | Query, Optional | Criteria for ordering results.<br>See "Ordering Results" section for details. |
| `options` | [`OptionsEnum`](../../doc/models/options-enum.md) | Query, Optional | Options dictionary |

## Response Type

[`List<ListEntitiesResponse>`](../../doc/models/list-entities-response.md)

## Example Usage

```java
String id = "Boe_Idearium";
String type = "Room";
String idPattern = "Bode_.*";
String typePattern = "Room_.*";
String q = "temperature>40";
String mq = "temperature.accuracy<0.9";
String georel = "near";
String geometry = "point";
String coords = "41.390205,2.154007;48.8566,2.3522";
Double limit = 237.24;
Double offset = 110.2;
String attrs = "seatNumber";
String metadata = "accuracy";
String orderBy = "temperature,!speed";

entitiesController.listEntitiesAsync(id, type, idPattern, typePattern, q, mq, georel, geometry, coords, limit, offset, attrs, metadata, orderBy, null).thenAccept(result -> {
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
    "type": "Room",
    "id": "DC_S1-D41",
    "temperature": {
      "value": 35.6,
      "type": "Number",
      "metadata": {}
    }
  },
  {
    "type": "Room",
    "id": "Boe-Idearium",
    "temperature": {
      "value": 22.5,
      "type": "Number",
      "metadata": {}
    }
  },
  {
    "type": "Car",
    "id": "P-9873-K",
    "speed": {
      "value": 100,
      "type": "number",
      "metadata": {
        "accuracy": {
          "value": 2,
          "type": "Number"
        },
        "timestamp": {
          "value": "2015-06-04T07:20:27.378Z",
          "type": "DateTime"
        }
      }
    }
  }
]
```


# Create Entity

The payload is an object representing the entity to be created. The object follows
the JSON entity representation format (described in a "JSON Entity Representation" section).

Response:

* Successful operation uses 201 Created (if upsert option is not used) or 204 No Content (if
  upsert option is used). Response includes a `Location` header with the URL of the
  created entity.

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> createEntityAsync(
    final CreateEntityRequest body,
    final Options1Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateEntityRequest`](../../doc/models/create-entity-request.md) | Body, Required | - |
| `options` | [`Options1Enum`](../../doc/models/options-1-enum.md) | Query, Optional | Options dictionary |

## Response Type

`void`

## Example Usage

```java
CreateEntityRequest body = new CreateEntityRequest();
body.setType("Room");
body.setId("Bcn-Welt");
body.setTemperature(new Temperature1());
body.getTemperature().setValue(21.7);
body.setHumidity(new Humidity());
body.getHumidity().setValue(60);
body.setLocation(new Location());
body.getLocation().setValue("41.3763726, 2.1864475");
body.getLocation().setType("geo:point");
body.getLocation().setMetadata(new Metadata1());
body.getLocation().getMetadata().setCrs(new Crs());
body.getLocation().getMetadata().getCrs().setValue("WGS84");

entitiesController.createEntityAsync(body, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Entity

The response is an object representing the entity identified by the ID. The object follows
the JSON entity representation format (described in "JSON Entity Representation" section).

This operation must return one entity element only, but there may be more than one entity with the
same ID (e.g. entities with same ID but different types).
In such case, an error message is returned, with the HTTP status code set to 409 Conflict.

Response:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for more details.

```java
CompletableFuture<RetrieveEntityResponse> retrieveEntityAsync(
    final String entityId,
    final String type,
    final String attrs,
    final String metadata,
    final Options2Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity to be retrieved |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |
| `attrs` | `String` | Query, Optional | Comma-separated list of attribute names whose<br>data must be included in the response. The attributes are retrieved in the order specified by<br>this parameter. See "Filtering out attributes and metadata" section for more detail.<br>If this parameter is not included, the attributes are retrieved in arbitrary order, and all<br>the attributes of the entity are included in the response. |
| `metadata` | `String` | Query, Optional | A list of metadata names to include in the response.<br>See "Filtering out attributes and metadata" section for more detail. |
| `options` | [`Options2Enum`](../../doc/models/options-2-enum.md) | Query, Optional | Options dictionary |

## Response Type

[`RetrieveEntityResponse`](../../doc/models/retrieve-entity-response.md)

## Example Usage

```java
String entityId = "entityId2";
String attrs = "temperature,humidity";
String metadata = "accuracy";

entitiesController.retrieveEntityAsync(entityId, null, attrs, metadata, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response *(as JSON)*

```json
{
  "type": "Room",
  "id": "Bcn_Welt",
  "temperature": {
    "value": 21.7,
    "type": "Number"
  },
  "humidity": {
    "value": 60,
    "type": "Number"
  },
  "location": {
    "value": "41.3763726, 2.1864475",
    "type": "geo:point",
    "metadata": {
      "crs": {
        "value": "WGS84",
        "type": "Text"
      }
    }
  }
}
```


# Retrieve Entity Attributes

This request is similar to retreiving the whole entity, however this one omits the `id` and `type`
fields.

Just like the general request of getting an entire entity, this operation must return only one
entity element. If more than one entity with the same ID is found (e.g. entities with
same ID but different type), an error message is returned, with the HTTP status code set to
409 Conflict.

Response:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<RetrieveEntityAttributesResponse> retrieveEntityAttributesAsync(
    final String entityId,
    final String type,
    final String attrs,
    final String metadata,
    final Options2Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity to be retrieved |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |
| `attrs` | `String` | Query, Optional | Comma-separated list of attribute names whose<br>data are to be included in the response. The attributes are retrieved in the order specified<br>by this parameter.<br>If this parameter is not included, the attributes are retrieved in arbitrary order, and all<br>the attributes of the entity are included in the response.<br>See "Filtering out attributes and metadata" section for more detail. |
| `metadata` | `String` | Query, Optional | A list of metadata names to include in the response.<br>See "Filtering out attributes and metadata" section for more detail. |
| `options` | [`Options2Enum`](../../doc/models/options-2-enum.md) | Query, Optional | Options dictionary |

## Response Type

[`RetrieveEntityAttributesResponse`](../../doc/models/retrieve-entity-attributes-response.md)

## Example Usage

```java
String entityId = "entityId2";
String attrs = "temperature,humidity";
String metadata = "accuracy";

entitiesController.retrieveEntityAttributesAsync(entityId, null, attrs, metadata, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response *(as JSON)*

```json
{
  "temperature": {
    "value": 21.7,
    "type": "Number"
  },
  "humidity": {
    "value": 60,
    "type": "Number"
  },
  "location": {
    "value": "41.3763726, 2.1864475",
    "type": "geo:point",
    "metadata": {
      "crs": {
        "value": "WGS84",
        "type": "Text"
      }
    }
  }
}
```


# Update or Append Entity Attributes

The request payload is an object representing the attributes to append or update. The object follows
the JSON entity representation format (described in "JSON Entity Representation" section), except
that `id` and `type` are not allowed.

The entity attributes are updated with the ones in the payload, depending on
whether the `append` operation option is used or not.

* If `append` is not used: the entity attributes are updated (if they previously exist) or appended
  (if they don't previously exist) with the ones in the payload.

* If `append` is used (i.e. strict append semantics): all the attributes in the payload not
  previously existing in the entity are appended. In addition to that, in case some of the
  attributes in the payload already exist in the entity, an error is returned.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> updateOrAppendEntityAttributesAsync(
    final String entityId,
    final UpdateOrAppendEntityAttributesRequest body,
    final String type,
    final Options4Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Entity id to be updated |
| `body` | [`UpdateOrAppendEntityAttributesRequest`](../../doc/models/update-or-append-entity-attributes-request.md) | Body, Required | - |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |
| `options` | [`Options4Enum`](../../doc/models/options-4-enum.md) | Query, Optional | Operations options |

## Response Type

`void`

## Example Usage

```java
String entityId = "entityId2";
UpdateOrAppendEntityAttributesRequest body = new UpdateOrAppendEntityAttributesRequest();
body.setAmbientNoise(new AmbientNoise());
body.getAmbientNoise().setValue(31.5);

entitiesController.updateOrAppendEntityAttributesAsync(entityId, body, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Existing Entity Attributes

The request payload is an object representing the attributes to update. The object follows
the JSON entity representation format (described in "JSON Entity Representation" section), except
that `id` and `type` are not allowed.

The entity attributes are updated with the ones in the payload. In addition to that, if one or more
attributes in the payload doesn't exist in the entity, an error is returned.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> updateExistingEntityAttributesAsync(
    final String entityId,
    final UpdateExistingEntityAttributesRequest body,
    final String type,
    final Options5Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity to be updated |
| `body` | [`UpdateExistingEntityAttributesRequest`](../../doc/models/update-existing-entity-attributes-request.md) | Body, Required | - |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |
| `options` | [`Options5Enum`](../../doc/models/options-5-enum.md) | Query, Optional | Operations options |

## Response Type

`void`

## Example Usage

```java
String entityId = "entityId2";
UpdateExistingEntityAttributesRequest body = new UpdateExistingEntityAttributesRequest();
body.setTemperature(new Temperature1());
body.getTemperature().setValue(25.5);
body.setSeatNumber(new SeatNumber());
body.getSeatNumber().setValue(6);

entitiesController.updateExistingEntityAttributesAsync(entityId, body, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Replace All Entity Attributes

The request payload is an object representing the new entity attributes. The object follows
the JSON entity representation format (described in a "JSON Entity Representation" above), except
that `id` and `type` are not allowed.

The attributes previously existing in the entity are removed and replaced by the ones in the
request.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> replaceAllEntityAttributesAsync(
    final String entityId,
    final ReplaceAllEntityAttributesRequest body,
    final String type,
    final Options5Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity in question. |
| `body` | [`ReplaceAllEntityAttributesRequest`](../../doc/models/replace-all-entity-attributes-request.md) | Body, Required | - |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |
| `options` | [`Options5Enum`](../../doc/models/options-5-enum.md) | Query, Optional | Operations options |

## Response Type

`void`

## Example Usage

```java
String entityId = "entityId2";
ReplaceAllEntityAttributesRequest body = new ReplaceAllEntityAttributesRequest();
body.setTemperature(new Temperature1());
body.getTemperature().setValue(25.5);
body.setSeatNumber(new SeatNumber());
body.getSeatNumber().setValue(6);

entitiesController.replaceAllEntityAttributesAsync(entityId, body, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Remove Entity

Delete the entity.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> removeEntityAsync(
    final String entityId,
    final String type)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity to be deleted |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |

## Response Type

`void`

## Example Usage

```java
String entityId = "entityId2";

entitiesController.removeEntityAsync(entityId, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

