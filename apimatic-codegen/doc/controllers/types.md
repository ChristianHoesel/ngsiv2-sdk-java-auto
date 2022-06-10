# Types

```java
TypesController typesController = client.getTypesController();
```

## Class Name

`TypesController`

## Methods

* [List Entity Types](../../doc/controllers/types.md#list-entity-types)
* [Retrieve Entity Type](../../doc/controllers/types.md#retrieve-entity-type)


# List Entity Types

If the `values` option is not in use, this operation returns a JSON array with the entity types.
Each element is a JSON object with information about the type:

* `type` : the entity type name.

* `attrs` : the set of attribute names along with all the entities of such type, represented in
  a JSON object whose keys are the attribute names and whose values contain information of such
  attributes (in particular a list of the types used by attributes with that name along with all the
  entities).

* `count` : the number of entities belonging to that type.

If the `values` option is used, the operation returns a JSON array with a list of entity type
names as strings.

Results are ordered by entity `type` in alphabetical order.

Response code:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<List<ListEntityTypesResponse>> listEntityTypesAsync(
    final Double limit,
    final Double offset,
    final Options7Enum options)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `limit` | `Double` | Query, Optional | Limit the number of types to be retrieved. |
| `offset` | `Double` | Query, Optional | Skip a number of records. |
| `options` | [`Options7Enum`](../../doc/models/options-7-enum.md) | Query, Optional | Options dictionary. |

## Response Type

[`List<ListEntityTypesResponse>`](../../doc/models/list-entity-types-response.md)

## Example Usage

```java
Double limit = 237.24;
Double offset = 110.2;

typesController.listEntityTypesAsync(limit, offset, null).thenAccept(result -> {
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
    "type": "Car",
    "attrs": {
      "speed": {
        "types": [
          "Number"
        ]
      },
      "fuel": {
        "types": [
          "gasoline",
          "diesel"
        ]
      },
      "temperature": {
        "types": [
          "urn:phenomenum:temperature"
        ]
      }
    },
    "count": 12
  },
  {
    "type": "Room",
    "attrs": {
      "pressure": {
        "types": [
          "Number"
        ]
      },
      "humidity": {
        "types": [
          "percentage"
        ]
      },
      "temperature": {
        "types": [
          "urn:phenomenum:temperature"
        ]
      }
    },
    "count": 7
  }
]
```


# Retrieve Entity Type

This operation returns a JSON object with information about the type:

* `attrs` : the set of attribute names along with all the entities of such type, represented in
  a JSON object whose keys are the attribute names and whose values contain information of such
  attributes (in particular a list of the types used by attributes with that name along with all the
  entities).

* `count` : the number of entities belonging to that type.

Response code:

* Successful operation uses 200 OK

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<RetrieveEntityTypeResponse> retrieveEntityTypeAsync(
    final String entityType)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityType` | `String` | Template, Required | Entity Type |

## Response Type

[`RetrieveEntityTypeResponse`](../../doc/models/retrieve-entity-type-response.md)

## Example Usage

```java
String entityType = "Room";

typesController.retrieveEntityTypeAsync(entityType).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response *(as JSON)*

```json
{
  "attrs": {
    "pressure": {
      "types": [
        "Number"
      ]
    },
    "humidity": {
      "types": [
        "percentage"
      ]
    },
    "temperature": {
      "types": [
        "urn:phenomenum:temperature"
      ]
    }
  },
  "count": 7
}
```

