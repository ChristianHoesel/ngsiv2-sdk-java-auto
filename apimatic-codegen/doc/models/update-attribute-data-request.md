
# Update Attribute Data Request

## Structure

`UpdateAttributeDataRequest`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Value` | `double` | Required | - | double getValue() | setValue(double value) |
| `Metadata` | [`Metadata5`](../../doc/models/metadata-5.md) | Required | - | Metadata5 getMetadata() | setMetadata(Metadata5 metadata) |

## Example (as JSON)

```json
{
  "value": 25.0,
  "metadata": {
    "unitCode": {
      "value": "CEL"
    }
  }
}
```

