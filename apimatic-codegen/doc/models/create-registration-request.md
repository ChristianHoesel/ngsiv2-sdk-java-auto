
# Create Registration Request

## Structure

`CreateRegistrationRequest`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Description` | `String` | Required | - | String getDescription() | setDescription(String description) |
| `DataProvided` | [`DataProvided`](../../doc/models/data-provided.md) | Required | - | DataProvided getDataProvided() | setDataProvided(DataProvided dataProvided) |
| `Provider` | [`Provider1`](../../doc/models/provider-1.md) | Required | - | Provider1 getProvider() | setProvider(Provider1 provider) |

## Example (as JSON)

```json
{
  "description": "Relative Humidity Context Source",
  "dataProvided": {
    "entities": [
      {
        "id": "room2",
        "type": "Room"
      }
    ],
    "attrs": [
      "relativeHumidity"
    ]
  },
  "provider": {
    "http": {
      "url": "http://localhost:1234"
    }
  }
}
```

