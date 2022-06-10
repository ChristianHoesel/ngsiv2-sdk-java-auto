
# List Entities Response

## Structure

`ListEntitiesResponse`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Id` | `String` | Required | - | String getId() | setId(String id) |
| `Temperature` | [`Temperature`](../../doc/models/temperature.md) | Optional | - | Temperature getTemperature() | setTemperature(Temperature temperature) |
| `Speed` | [`Speed`](../../doc/models/speed.md) | Optional | - | Speed getSpeed() | setSpeed(Speed speed) |

## Example (as JSON)

```json
{
  "type": "Room",
  "id": "DC_S1-D41",
  "temperature": {
    "value": 35.6,
    "type": "Number",
    "metadata": {}
  }
}
```

