
# Notify Request

## Structure

`NotifyRequest`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `SubscriptionId` | `String` | Required | - | String getSubscriptionId() | setSubscriptionId(String subscriptionId) |
| `Data` | [`List<Datum>`](../../doc/models/datum.md) | Required | - | List<Datum> getData() | setData(List<Datum> data) |

## Example (as JSON)

```json
{
  "subscriptionId": "5aeb0ee97d4ef10a12a0262f",
  "data": [
    {
      "type": "Room",
      "id": "DC_S1-D41",
      "temperature": {
        "value": 35.6,
        "type": "Number"
      }
    },
    {
      "type": "Room",
      "id": "Boe-Idearium",
      "temperature": {
        "value": 22.5,
        "type": "Number"
      }
    }
  ]
}
```

