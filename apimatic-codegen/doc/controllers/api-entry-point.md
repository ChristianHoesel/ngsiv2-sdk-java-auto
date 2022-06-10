# API Entry Point

```java
APIEntryPointController aPIEntryPointController = client.getAPIEntryPointController();
```

## Class Name

`APIEntryPointController`


# Retrieve API Resources

This resource does not have any attributes. Instead it offers the initial
API affordances in the form of the links in the JSON body.

It is recommended to follow the “url” link values,
[Link](https://tools.ietf.org/html/rfc5988) or Location headers where
applicable to retrieve resources. Instead of constructing your own URLs,
to keep your client decoupled from implementation details.

```java
CompletableFuture<RetrieveAPIResourcesResponse> retrieveAPIResourcesAsync()
```

## Response Type

[`RetrieveAPIResourcesResponse`](../../doc/models/retrieve-api-resources-response.md)

## Example Usage

```java
aPIEntryPointController.retrieveAPIResourcesAsync().thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response *(as JSON)*

```json
{
  "entities_url": "/v2/entities",
  "types_url": "/v2/types",
  "subscriptions_url": "/v2/subscriptions",
  "registrations_url": "/v2/registrations"
}
```

