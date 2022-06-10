
# Location 2

## Structure

`Location2`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Value` | `String` | Required | - | String getValue() | setValue(String value) |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Metadata` | [`Metadata3`](../../doc/models/metadata-3.md) | Required | - | Metadata3 getMetadata() | setMetadata(Metadata3 metadata) |

## Example (as JSON)

```json
{
  "value": "41.3763726, 2.1864475",
  "type": "geo:point",
  "metadata": {
    "crs": {
      "value": "WGS84",
      "type": "Text"
    }
  }
}
```

