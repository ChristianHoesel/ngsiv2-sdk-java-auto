
# Location

## Structure

`Location`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Value` | `String` | Required | - | String getValue() | setValue(String value) |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Metadata` | [`Metadata1`](../../doc/models/metadata-1.md) | Required | - | Metadata1 getMetadata() | setMetadata(Metadata1 metadata) |

## Example (as JSON)

```json
{
  "value": "41.3763726, 2.1864475",
  "type": "geo:point",
  "metadata": {
    "crs": {
      "value": "WGS84"
    }
  }
}
```

