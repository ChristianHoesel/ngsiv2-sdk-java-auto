
# Speed

## Structure

`Speed`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Value` | `int` | Required | - | int getValue() | setValue(int value) |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Metadata` | [`Metadata`](../../doc/models/metadata.md) | Required | - | Metadata getMetadata() | setMetadata(Metadata metadata) |

## Example (as JSON)

```json
{
  "value": 100,
  "type": "number",
  "metadata": {
    "accuracy": {
      "value": 2,
      "type": "Number"
    },
    "timestamp": {
      "value": "2015-06-04T07:20:27.378Z",
      "type": "DateTime"
    }
  }
}
```

