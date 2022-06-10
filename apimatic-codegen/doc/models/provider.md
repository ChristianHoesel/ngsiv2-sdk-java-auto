
# Provider

## Structure

`Provider`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Http` | [`Http`](../../doc/models/http.md) | Required | - | Http getHttp() | setHttp(Http http) |
| `SupportedForwardingMode` | `String` | Required | - | String getSupportedForwardingMode() | setSupportedForwardingMode(String supportedForwardingMode) |

## Example (as JSON)

```json
{
  "http": {
    "url": "http://contextsource.example.org"
  },
  "supportedForwardingMode": "all"
}
```

