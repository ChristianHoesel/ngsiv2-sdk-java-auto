
# Http Custom

## Structure

`HttpCustom`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Url` | `String` | Required | - | String getUrl() | setUrl(String url) |
| `Headers` | [`Headers`](../../doc/models/headers.md) | Required | - | Headers getHeaders() | setHeaders(Headers headers) |
| `Qs` | [`Qs`](../../doc/models/qs.md) | Required | - | Qs getQs() | setQs(Qs qs) |

## Example (as JSON)

```json
{
  "url": "http://localhost:1234",
  "headers": {
    "X-MyHeader": "foo"
  },
  "qs": {
    "authToken": "bar"
  }
}
```

