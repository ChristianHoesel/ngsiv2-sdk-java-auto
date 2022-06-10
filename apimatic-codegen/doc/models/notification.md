
# Notification

## Structure

`Notification`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `HttpCustom` | [`HttpCustom`](../../doc/models/http-custom.md) | Required | - | HttpCustom getHttpCustom() | setHttpCustom(HttpCustom httpCustom) |
| `AttrsFormat` | `String` | Required | - | String getAttrsFormat() | setAttrsFormat(String attrsFormat) |
| `Attrs` | `List<String>` | Required | - | List<String> getAttrs() | setAttrs(List<String> attrs) |
| `TimesSent` | `int` | Required | - | int getTimesSent() | setTimesSent(int timesSent) |
| `LastNotification` | `String` | Required | - | String getLastNotification() | setLastNotification(String lastNotification) |
| `LastFailure` | `String` | Required | - | String getLastFailure() | setLastFailure(String lastFailure) |

## Example (as JSON)

```json
{
  "httpCustom": {
    "url": "http://localhost:1234",
    "headers": {
      "X-MyHeader": "foo"
    },
    "qs": {
      "authToken": "bar"
    }
  },
  "attrsFormat": "keyValues",
  "attrs": [
    "temperature",
    "humidity"
  ],
  "timesSent": 12,
  "lastNotification": "2015-10-05T16:00:00.00Z",
  "lastFailure": "2015-10-06T16:00:00.00Z"
}
```

