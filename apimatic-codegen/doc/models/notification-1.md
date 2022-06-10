
# Notification 1

## Structure

`Notification1`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Http` | [`Http`](../../doc/models/http.md) | Required | - | Http getHttp() | setHttp(Http http) |
| `Attrs` | `List<String>` | Required | - | List<String> getAttrs() | setAttrs(List<String> attrs) |

## Example (as JSON)

```json
{
  "http": {
    "url": "http://localhost:1234"
  },
  "attrs": [
    "temperature",
    "humidity"
  ]
}
```

