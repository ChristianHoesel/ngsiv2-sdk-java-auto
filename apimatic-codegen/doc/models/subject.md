
# Subject

## Structure

`Subject`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Entities` | [`List<Entity>`](../../doc/models/entity.md) | Required | - | List<Entity> getEntities() | setEntities(List<Entity> entities) |
| `Condition` | [`Condition`](../../doc/models/condition.md) | Required | - | Condition getCondition() | setCondition(Condition condition) |

## Example (as JSON)

```json
{
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
}
```

