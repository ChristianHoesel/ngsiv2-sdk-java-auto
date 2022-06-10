
# List Subscriptions Response

## Structure

`ListSubscriptionsResponse`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Id` | `String` | Required | - | String getId() | setId(String id) |
| `Description` | `String` | Required | - | String getDescription() | setDescription(String description) |
| `Subject` | [`Subject`](../../doc/models/subject.md) | Required | - | Subject getSubject() | setSubject(Subject subject) |
| `Notification` | [`Notification`](../../doc/models/notification.md) | Required | - | Notification getNotification() | setNotification(Notification notification) |
| `Expires` | `String` | Required | - | String getExpires() | setExpires(String expires) |
| `Status` | `String` | Required | - | String getStatus() | setStatus(String status) |
| `Throttling` | `int` | Required | - | int getThrottling() | setThrottling(int throttling) |

## Example (as JSON)

```json
{
  "id": "abcdefg",
  "description": "One subscription to rule them all",
  "subject": {
    "entities": [
      {
        "id": "Bcn_Welt",
        "type": "Room"
      }
    ],
    "condition": {
      "attrs": [
        "temperature "
      ],
      "expression": {
        "q": "temperature>40"
      }
    }
  },
  "notification": {
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
  },
  "expires": "2016-04-05T14:00:00.00Z",
  "status": "failed",
  "throttling": 5
}
```

