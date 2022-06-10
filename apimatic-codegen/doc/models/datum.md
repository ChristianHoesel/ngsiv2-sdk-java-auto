
# Datum

## Structure

`Datum`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Id` | `String` | Required | - | String getId() | setId(String id) |
| `Temperature` | [`Temperature3`](../../doc/models/temperature-3.md) | Required | - | Temperature3 getTemperature() | setTemperature(Temperature3 temperature) |

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

