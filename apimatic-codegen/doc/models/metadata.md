
# Metadata

## Structure

`Metadata`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Accuracy` | [`Accuracy`](../../doc/models/accuracy.md) | Required | - | Accuracy getAccuracy() | setAccuracy(Accuracy accuracy) |
| `Timestamp` | [`Timestamp`](../../doc/models/timestamp.md) | Required | - | Timestamp getTimestamp() | setTimestamp(Timestamp timestamp) |

## Example (as JSON)

```json
{
  "accuracy": {
    "value": 2,
    "type": "Number"
  },
  "timestamp": {
    "value": "2015-06-04T07:20:27.378Z",
    "type": "DateTime"
  }
}
```

