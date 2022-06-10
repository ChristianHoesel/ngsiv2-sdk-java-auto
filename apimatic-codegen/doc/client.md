
# Client Class Documentation

The following parameters are configurable for the API Client:

| Parameter | Type | Description |
|  --- | --- | --- |
| `httpClientConfig` | `ReadonlyHttpClientConfiguration` | Http Client Configuration instance. |

The API client can be initialized as follows:

```java
FIWARENGSIV2SpecificationClient client = new FIWARENGSIV2SpecificationClient.Builder()
    .httpClientConfig(configBuilder -> configBuilder
            .timeout(0))
    .build();
```

## FIWARE-NGSI v2 SpecificationClient Class

The gateway for the SDK. This class acts as a factory for the Controllers and also holds the configuration of the SDK.

### Controllers

| Name | Description | Return Type |
|  --- | --- | --- |
| `getAPIEntryPointController()` | Provides access to APIEntryPoint controller. | `APIEntryPointController` |
| `getEntitiesController()` | Provides access to Entities controller. | `EntitiesController` |
| `getAttributesController()` | Provides access to Attributes controller. | `AttributesController` |
| `getAttributeValueController()` | Provides access to AttributeValue controller. | `AttributeValueController` |
| `getTypesController()` | Provides access to Types controller. | `TypesController` |
| `getSubscriptionsController()` | Provides access to Subscriptions controller. | `SubscriptionsController` |
| `getRegistrationsController()` | Provides access to Registrations controller. | `RegistrationsController` |
| `getBatchOperationsController()` | Provides access to BatchOperations controller. | `BatchOperationsController` |

### Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `shutdown()` | Shutdown the underlying HttpClient instance. | `void` |
| `getEnvironment()` | Current API environment. | `Environment` |
| `getHttpClient()` | The HTTP Client instance to use for making HTTP requests. | `HttpClient` |
| `getHttpClientConfig()` | Http Client Configuration instance. | `ReadonlyHttpClientConfiguration` |
| `getBaseUri(Server server)` | Get base URI by current environment | `String` |
| `getBaseUri()` | Get base URI by current environment | `String` |

