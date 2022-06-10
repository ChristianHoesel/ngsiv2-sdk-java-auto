
# Update Request

## Structure

`UpdateRequest`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `ActionType` | `String` | Required | - | String getActionType() | setActionType(String actionType) |
| `Entities` | [`List<Entity5>`](../../doc/models/entity-5.md) | Required | - | List<Entity5> getEntities() | setEntities(List<Entity5> entities) |

## Example (as JSON)

```json
{
  "actionType": "append",
  "entities": [
    {
      "type": "Room",
      "id": "Bcn-Welt",
      "temperature": {
        "value": 21.7
      },
      "humidity": {
        "value": 60
      }
    },
    {
      "type": "Room",
      "id": "Mad_Aud",
      "temperature": {
        "value": 22.9
      },
      "humidity": {
        "value": 85
      }
    }
  ]
}
```

