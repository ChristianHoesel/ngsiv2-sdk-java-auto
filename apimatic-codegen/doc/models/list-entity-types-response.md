
# List Entity Types Response

## Structure

`ListEntityTypesResponse`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Type` | `String` | Required | - | String getType() | setType(String type) |
| `Attrs` | [`Attrs`](../../doc/models/attrs.md) | Required | - | Attrs getAttrs() | setAttrs(Attrs attrs) |
| `Count` | `int` | Required | - | int getCount() | setCount(int count) |

## Example (as JSON)

```json
{
  "type": "Car",
  "attrs": {
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
  },
  "count": 12
}
```

