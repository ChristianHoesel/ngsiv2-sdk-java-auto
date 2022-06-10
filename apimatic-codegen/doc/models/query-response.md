
# Query Response

## Structure

`QueryResponse`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Id` | `String` | Required | - | String getId() | setId(String id) |
| `Temperature` | [`Temperature10`](../../doc/models/temperature-10.md) | Required | - | Temperature10 getTemperature() | setTemperature(Temperature10 temperature) |

## Example (as JSON)

```json
{
  "type": "Room",
  "id": "DC_S1-D41",
  "temperature": {
    "value": 35.6,
    "type": "Number"
  }
}
```

