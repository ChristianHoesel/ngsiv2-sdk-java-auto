
# Retrieve Entity Response

## Structure

`RetrieveEntityResponse`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Id` | `String` | Required | - | String getId() | setId(String id) |
| `Temperature` | [`Temperature3`](../../doc/models/temperature-3.md) | Required | - | Temperature3 getTemperature() | setTemperature(Temperature3 temperature) |
| `Humidity` | [`Humidity2`](../../doc/models/humidity-2.md) | Required | - | Humidity2 getHumidity() | setHumidity(Humidity2 humidity) |
| `Location` | [`Location2`](../../doc/models/location-2.md) | Required | - | Location2 getLocation() | setLocation(Location2 location) |

## Example (as JSON)

```json
{
  "type": "Room",
  "id": "Bcn_Welt",
  "temperature": {
    "value": 21.7,
    "type": "Number"
  },
  "humidity": {
    "value": 60,
    "type": "Number"
  },
  "location": {
    "value": "41.3763726, 2.1864475",
    "type": "geo:point",
    "metadata": {
      "crs": {
        "value": "WGS84",
        "type": "Text"
      }
    }
  }
}
```

