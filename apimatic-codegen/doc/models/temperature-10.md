
# Temperature 10

## Structure

`Temperature10`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Value` | [`Temperature10Value`]($m/Temperature10Value) | Required | - | Temperature10Value getValue() | setValue(Temperature10Value value) |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Accuracy` | `Integer` | Optional | - | Integer getAccuracy() | setAccuracy(Integer accuracy) |
| `Timestamp` | [`Timestamp`](../../doc/models/timestamp.md) | Optional | - | Timestamp getTimestamp() | setTimestamp(Timestamp timestamp) |

## Example (as JSON)

```json
{
  "value": 35.6,
  "type": "Number"
}
```

