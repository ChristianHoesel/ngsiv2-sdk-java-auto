
# Update Attribute Value Request

## Structure

`UpdateAttributeValueRequest`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Address` | `String` | Required | - | String getAddress() | setAddress(String address) |
| `ZipCode` | `int` | Required | - | int getZipCode() | setZipCode(int zipCode) |
| `City` | `String` | Required | - | String getCity() | setCity(String city) |
| `Country` | `String` | Required | - | String getCountry() | setCountry(String country) |

## Example (as JSON)

```json
{
  "address": "Ronda de la Comunicacion s/n",
  "zipCode": 28050,
  "city": "Madrid",
  "country": "Spain"
}
```

