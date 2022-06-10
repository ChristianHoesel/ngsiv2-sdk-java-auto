
# Data Provided

## Structure

`DataProvided`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Entities` | [`List<Entity>`](../../doc/models/entity.md) | Required | - | List<Entity> getEntities() | setEntities(List<Entity> entities) |
| `Attrs` | `List<String>` | Required | - | List<String> getAttrs() | setAttrs(List<String> attrs) |

## Example (as JSON)

```json
{
  "entities": [
    {
      "id": "Bcn_Welt",
      "type": "Room"
    }
  ],
  "attrs": [
    "temperature"
  ]
}
```

