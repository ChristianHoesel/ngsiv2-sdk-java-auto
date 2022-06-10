
# Retrieve API Resources Response

## Structure

`RetrieveAPIResourcesResponse`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `EntitiesUrl` | `String` | Required | URL which points to the entities resource | String getEntitiesUrl() | setEntitiesUrl(String entitiesUrl) |
| `TypesUrl` | `String` | Required | URL which points to the types resource | String getTypesUrl() | setTypesUrl(String typesUrl) |
| `SubscriptionsUrl` | `String` | Required | URL which points to the<br><br>subscriptions resource | String getSubscriptionsUrl() | setSubscriptionsUrl(String subscriptionsUrl) |
| `RegistrationsUrl` | `String` | Required | URL which points to the<br><br>registrations resource | String getRegistrationsUrl() | setRegistrationsUrl(String registrationsUrl) |

## Example (as JSON)

```json
{
  "entities_url": "/v2/entities",
  "types_url": "/v2/types",
  "subscriptions_url": "/v2/subscriptions",
  "registrations_url": "/v2/registrations"
}
```

