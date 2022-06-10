# Attributes

```java
AttributesController attributesController = client.getAttributesController();
```

## Class Name

`AttributesController`

## Methods

* [Get Attribute Data](../../doc/controllers/attributes.md#get-attribute-data)
* [Update Attribute Data](../../doc/controllers/attributes.md#update-attribute-data)
* [Remove a Single Attribute](../../doc/controllers/attributes.md#remove-a-single-attribute)


# Get Attribute Data

Returns a JSON object with the attribute data of the attribute. The object follows the JSON
representation for attributes (described in "JSON Attribute Representation" section).

Response:

* Successful operation uses 200 OK.

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<GetAttributeDataResponse> getAttributeDataAsync(
    final String entityId,
    final String attrName,
    final String type,
    final String metadata)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity |
| `attrName` | `String` | Template, Required | Name of the attribute to be retrieved. |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |
| `metadata` | `String` | Query, Optional | A list of metadata names to include in the response.<br>See "Filtering out attributes and metadata" section for more detail. |

## Response Type

[`GetAttributeDataResponse`](../../doc/models/get-attribute-data-response.md)

## Example Usage

```java
String entityId = "Bcn_Welt";
String attrName = "temperature";
String metadata = "accuracy";

attributesController.getAttributeDataAsync(entityId, attrName, null, metadata).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response *(as JSON)*

```json
{
  "value": 21.7,
  "type": "Number",
  "metadata": {}
}
```


# Update Attribute Data

The request payload is an object representing the new attribute data. Previous attribute data
is replaced by the one in the request. The object follows the JSON representation for attributes
(described in "JSON Attribute Representation" section).

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> updateAttributeDataAsync(
    final String entityId,
    final String attrName,
    final UpdateAttributeDataRequest body,
    final String type)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity to update |
| `attrName` | `String` | Template, Required | Attribute name |
| `body` | [`UpdateAttributeDataRequest`](../../doc/models/update-attribute-data-request.md) | Body, Required | - |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |

## Response Type

`void`

## Example Usage

```java
String entityId = "Bcn_Welt";
String attrName = "temperature";
UpdateAttributeDataRequest body = new UpdateAttributeDataRequest();
body.setValue(25);
body.setMetadata(new Metadata5());
body.getMetadata().setUnitCode(new UnitCode());
body.getMetadata().getUnitCode().setValue("CEL");

attributesController.updateAttributeDataAsync(entityId, attrName, body, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Remove a Single Attribute

Removes an entity attribute.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> removeASingleAttributeAsync(
    final String entityId,
    final String attrName,
    final String type)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity. |
| `attrName` | `String` | Template, Required | Attribute name. |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |

## Response Type

`void`

## Example Usage

```java
String entityId = "Bcn_Welt";
String attrName = "temperature";

attributesController.removeASingleAttributeAsync(entityId, attrName, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

