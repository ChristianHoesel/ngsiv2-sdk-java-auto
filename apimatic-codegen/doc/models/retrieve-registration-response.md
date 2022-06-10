
# Retrieve Registration Response

## Structure

`RetrieveRegistrationResponse`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Id` | `String` | Required | - | String getId() | setId(String id) |
| `Description` | `String` | Required | - | String getDescription() | setDescription(String description) |
| `DataProvided` | [`DataProvided`](../../doc/models/data-provided.md) | Required | - | DataProvided getDataProvided() | setDataProvided(DataProvided dataProvided) |
| `Provider` | [`Provider`](../../doc/models/provider.md) | Required | - | Provider getProvider() | setProvider(Provider provider) |
| `Expires` | `String` | Required | - | String getExpires() | setExpires(String expires) |
| `Status` | `String` | Required | - | String getStatus() | setStatus(String status) |
| `ForwardingInformation` | [`ForwardingInformation`](../../doc/models/forwarding-information.md) | Required | - | ForwardingInformation getForwardingInformation() | setForwardingInformation(ForwardingInformation forwardingInformation) |

## Example (as JSON)

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

