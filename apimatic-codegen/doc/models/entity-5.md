
# Entity 5

## Structure

`Entity5`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Id` | `String` | Required | - | String getId() | setId(String id) |
| `Temperature` | [`Temperature1`](../../doc/models/temperature-1.md) | Required | - | Temperature1 getTemperature() | setTemperature(Temperature1 temperature) |
| `Humidity` | [`Humidity`](../../doc/models/humidity.md) | Required | - | Humidity getHumidity() | setHumidity(Humidity humidity) |

## Example (as JSON)

```json
{
  "type": "Room",
  "id": "Bcn-Welt",
  "temperature": {
    "value": 21.7
  },
  "humidity": {
    "value": 60
  }
}
```

