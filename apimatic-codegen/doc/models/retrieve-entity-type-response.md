
# Retrieve Entity Type Response

## Structure

`RetrieveEntityTypeResponse`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Attrs` | [`Attrs1`](../../doc/models/attrs-1.md) | Required | - | Attrs1 getAttrs() | setAttrs(Attrs1 attrs) |
| `Count` | `int` | Required | - | int getCount() | setCount(int count) |

## Example (as JSON)

```json
{
  "attrs": {
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
  },
  "count": 7
}
```

