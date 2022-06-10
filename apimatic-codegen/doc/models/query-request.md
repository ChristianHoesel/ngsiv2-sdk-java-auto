
# Query Request

## Structure

`QueryRequest`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Entities` | [`List<Entity6>`](../../doc/models/entity-6.md) | Required | - | List<Entity6> getEntities() | setEntities(List<Entity6> entities) |
| `Attrs` | `List<String>` | Required | - | List<String> getAttrs() | setAttrs(List<String> attrs) |
| `Expression` | [`Expression`](../../doc/models/expression.md) | Required | - | Expression getExpression() | setExpression(Expression expression) |
| `Metadata` | `List<String>` | Required | - | List<String> getMetadata() | setMetadata(List<String> metadata) |

## Example (as JSON)

```json
{
  "entities": [
    {
      "idPattern": ".*",
      "type": "Room"
    },
    {
      "id": "Car",
      "type": "P-9873-K"
    }
  ],
  "attrs": [
    "temperature",
    "humidity"
  ],
  "expression": {
    "q": "temperature>20"
  },
  "metadata": [
    "accuracy",
    "timestamp"
  ]
}
```

