
# Condition

## Structure

`Condition`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Attrs` | `List<String>` | Required | - | List<String> getAttrs() | setAttrs(List<String> attrs) |
| `Expression` | [`Expression`](../../doc/models/expression.md) | Required | - | Expression getExpression() | setExpression(Expression expression) |

## Example (as JSON)

```json
{
  "attrs": [
    "temperature "
  ],
  "expression": {
    "q": "temperature>40"
  }
}
```

