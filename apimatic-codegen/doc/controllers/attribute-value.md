# Attribute Value

```java
AttributeValueController attributeValueController = client.getAttributeValueController();
```

## Class Name

`AttributeValueController`

## Methods

* [Get Attribute Value](../../doc/controllers/attribute-value.md#get-attribute-value)
* [Update Attribute Value](../../doc/controllers/attribute-value.md#update-attribute-value)


# Get Attribute Value

This operation returns the `value` property with the value of the attribute.

* If attribute value is JSON Array or Object:
  
  * If `Accept` header can be expanded to `application/json` or `text/plain` return the value as a JSON with a
    response type of application/json or text/plain (whichever is the first in `Accept` header or
    `application/json` in case of `Accept: */*`).
  * Else return a HTTP error "406 Not Acceptable: accepted MIME types: application/json, text/plain"

* If attribute value is a string, number, null or boolean:
  
  * If `Accept` header can be expanded to text/plain return the value as text. In case of a string, citation
    marks are used at the begining and end.
  * Else return a HTTP error "406 Not Acceptable: accepted MIME types: text/plain"

Response:

* Successful operation uses 200 OK.

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<GetAttributeValueResponse> getAttributeValueAsync(
    final String entityId,
    final String attrName,
    final String type)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity in question |
| `attrName` | `String` | Template, Required | Name of the attribute to be retrieved. |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |

## Response Type

[`GetAttributeValueResponse`](../../doc/models/get-attribute-value-response.md)

## Example Usage

```java
String entityId = "Bcn_Welt";
String attrName = "address";

attributeValueController.getAttributeValueAsync(entityId, attrName, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response *(as JSON)*

```json
{
  "address": "Ronda de la Comunicacion s/n",
  "zipCode": 28050,
  "city": "Madrid",
  "country": "Spain"
}
```


# Update Attribute Value

The request payload is the new attribute value.

* If the request payload MIME type is `application/json`, then the value of the attribute is set to
  the JSON object or array coded in the payload (if the payload is not a valid JSON document,
  then an error is returned).

* If the request payload MIME type is `text/plain`, then the following algorithm is applied to the
  payload:
  
  * If the payload starts and ends with citation-marks (`"`), the value is taken as a string
    (the citation marks themselves are not considered part of the string)
  * If `true` or `false`, the value is taken as a boolean.
  * If `null`, the value is taken as null.
  * If these first three tests 'fail', the text is interpreted as a number.
  * If not a valid number, then an error is returned and the attribute's value is unchanged.

The payload MIME type in the request is specified in the `Content-Type` HTTP header.

Response:

* Successful operation uses 204 No Content

* Errors use a non-2xx and (optionally) an error payload. See subsection on "Error Responses" for
  more details.

```java
CompletableFuture<Void> updateAttributeValueAsync(
    final String entityId,
    final String attrName,
    final UpdateAttributeValueRequest body,
    final String type)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `entityId` | `String` | Template, Required | Id of the entity to be updated. |
| `attrName` | `String` | Template, Required | Attribute name. |
| `body` | [`UpdateAttributeValueRequest`](../../doc/models/update-attribute-value-request.md) | Body, Required | - |
| `type` | `String` | Query, Optional | Entity type, to avoid ambiguity in case there are several<br>entities with the same entity id. |

## Response Type

`void`

## Example Usage

```java
String entityId = "Bcn_Welt";
String attrName = "address";
UpdateAttributeValueRequest body = new UpdateAttributeValueRequest();
body.setAddress("Ronda de la Comunicacion s/n");
body.setZipCode(28050);
body.setCity("Madrid");
body.setCountry("Spain");

attributeValueController.updateAttributeValueAsync(entityId, attrName, body, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

