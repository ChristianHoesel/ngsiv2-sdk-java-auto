
# Attrs 1

## Structure

`Attrs1`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Pressure` | [`Pressure`](../../doc/models/pressure.md) | Required | - | Pressure getPressure() | setPressure(Pressure pressure) |
| `Humidity` | [`Humidity4`](../../doc/models/humidity-4.md) | Required | - | Humidity4 getHumidity() | setHumidity(Humidity4 humidity) |
| `Temperature` | [`Temperature7`](../../doc/models/temperature-7.md) | Required | - | Temperature7 getTemperature() | setTemperature(Temperature7 temperature) |

## Example (as JSON)

```json
{
  "pressure": {
    "types": [
      "Number"
    ]
  },
  "humidity": {
    "types": [
      "percentage"
    ]
  },
  "temperature": {
    "types": [
      "urn:phenomenum:temperature"
    ]
  }
}
```

