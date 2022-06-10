
# Forwarding Information

## Structure

`ForwardingInformation`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `TimesSent` | `int` | Required | - | int getTimesSent() | setTimesSent(int timesSent) |
| `LastForwarding` | `String` | Required | - | String getLastForwarding() | setLastForwarding(String lastForwarding) |
| `LastSuccess` | `String` | Required | - | String getLastSuccess() | setLastSuccess(String lastSuccess) |
| `LastFailure` | `String` | Required | - | String getLastFailure() | setLastFailure(String lastFailure) |

## Example (as JSON)

```json
{
  "timesSent": 12,
  "lastForwarding": "2017-10-06T16:00:00.00Z",
  "lastSuccess": "2017-10-06T16:00:00.00Z",
  "lastFailure": "2017-10-05T16:00:00.00Z"
}
```

