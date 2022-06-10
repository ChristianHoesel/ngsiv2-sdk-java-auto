
# Update Existing Entity Attributes Request

## Structure

`UpdateExistingEntityAttributesRequest`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Temperature` | [`Temperature1`](../../doc/models/temperature-1.md) | Required | - | Temperature1 getTemperature() | setTemperature(Temperature1 temperature) |
| `SeatNumber` | [`SeatNumber`](../../doc/models/seat-number.md) | Required | - | SeatNumber getSeatNumber() | setSeatNumber(SeatNumber seatNumber) |

## Example (as JSON)

```json
{
  "temperature": {
    "value": 25.5
  },
  "seatNumber": {
    "value": 6
  }
}
```

