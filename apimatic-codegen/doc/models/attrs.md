
# Attrs

## Structure

`Attrs`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Speed` | [`Speed1`](../../doc/models/speed-1.md) | Optional | - | Speed1 getSpeed() | setSpeed(Speed1 speed) |
| `Fuel` | [`Fuel`](../../doc/models/fuel.md) | Optional | - | Fuel getFuel() | setFuel(Fuel fuel) |
| `Temperature` | [`Temperature7`](../../doc/models/temperature-7.md) | Required | - | Temperature7 getTemperature() | setTemperature(Temperature7 temperature) |
| `Pressure` | [`Pressure`](../../doc/models/pressure.md) | Optional | - | Pressure getPressure() | setPressure(Pressure pressure) |
| `Humidity` | [`Humidity4`](../../doc/models/humidity-4.md) | Optional | - | Humidity4 getHumidity() | setHumidity(Humidity4 humidity) |

## Example (as JSON)

```json
{
  "speed": {
    "types": [
      "Number"
    ]
  },
  "fuel": {
    "types": [
      "gasoline",
      "diesel"
    ]
  },
  "temperature": {
    "types": [
      "urn:phenomenum:temperature"
    ]
  }
}
```

