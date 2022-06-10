
# Create Subscription Request

## Structure

`CreateSubscriptionRequest`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Description` | `String` | Required | - | String getDescription() | setDescription(String description) |
| `Subject` | [`Subject1`](../../doc/models/subject-1.md) | Required | - | Subject1 getSubject() | setSubject(Subject1 subject) |
| `Notification` | [`Notification1`](../../doc/models/notification-1.md) | Required | - | Notification1 getNotification() | setNotification(Notification1 notification) |
| `Expires` | `String` | Required | - | String getExpires() | setExpires(String expires) |
| `Throttling` | `int` | Required | - | int getThrottling() | setThrottling(int throttling) |

## Example (as JSON)

```json
{
  "description": "One subscription to rule them all",
  "subject": {
    "entities": [
      {
        "idPattern": ".*",
        "type": "Room"
      }
    ],
    "condition": {
      "attrs": [
        "temperature"
      ],
      "expression": {
        "q": "temperature>40"
      }
    }
  },
  "notification": {
    "http": {
      "url": "http://localhost:1234"
    },
    "attrs": [
      "temperature",
      "humidity"
    ]
  },
  "expires": "2016-04-05T14:00:00.00Z",
  "throttling": 5
}
```

