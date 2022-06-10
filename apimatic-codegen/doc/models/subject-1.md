
# Subject 1

## Structure

`Subject1`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Entities` | [`List<Entity1>`](../../doc/models/entity-1.md) | Required | - | List<Entity1> getEntities() | setEntities(List<Entity1> entities) |
| `Condition` | [`Condition`](../../doc/models/condition.md) | Required | - | Condition getCondition() | setCondition(Condition condition) |

## Example (as JSON)

```json
{
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
}
```

