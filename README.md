# Auto-generated Java Client SDKs for NGSI v2

## [swagger-codegen](https://github.com/swagger-api/swagger-codegen)
* [NGSI v2 OpenAPI 2.0 Specification](https://github.com/FIWARE/specifications/blob/master/OpenAPI/ngsiv2/ngsiv2-openapi.json) (06cab79)
* [Download swagger-codegen-cli.jar](https://github.com/swagger-api/swagger-codegen#prerequisites) (v2.4.27)
  ```
  wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.27/swagger-codegen-cli-2.4.27.jar \
    -O swagger-codegen-cli.jar
  ```
* [Generate SDK](https://github.com/swagger-api/swagger-codegen#getting-started)
  ```
  java -jar swagger-codegen-cli.jar generate \
    -i https://raw.githubusercontent.com/FIWARE/specifications/master/OpenAPI/ngsiv2/ngsiv2-openapi.json \
    -l java \
    -o swagger-codegen
  ```

## [openapi-generator](https://github.com/OpenAPITools/openapi-generator)
* [NGSI v2 OpenAPI 2.0 Specification](https://github.com/FIWARE/specifications/blob/master/OpenAPI/ngsiv2/ngsiv2-openapi.json) (06cab79)
* [Download openapi-generator-cli.jar](https://github.com/OpenAPITools/openapi-generator#13---download-jar) (v6.0.0)
  ```
  wget https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/6.0.0/openapi-generator-cli-6.0.0.jar \
    -O openapi-generator-cli.jar
  ```
- [Generate SDK](https://github.com/OpenAPITools/openapi-generator#2---getting-started)
  ```
  java -jar openapi-generator-cli.jar generate \
    -i https://raw.githubusercontent.com/FIWARE/specifications/master/OpenAPI/ngsiv2/ngsiv2-openapi.json \
    -g java \
    -o openapi-generator
  ```

## [openapi-generator-native](https://github.com/OpenAPITools/openapi-generator)
* [NGSI v2 OpenAPI 2.0 Specification](https://github.com/FIWARE/specifications/blob/master/OpenAPI/ngsiv2/ngsiv2-openapi.json) (06cab79)
* [Download openapi-generator-cli.jar](https://github.com/OpenAPITools/openapi-generator#13---download-jar) (v6.0.0)
  ```
  wget https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/6.0.0/openapi-generator-cli-6.0.0.jar \
    -O openapi-generator-cli.jar
  ```
* [Generate SDK](https://github.com/OpenAPITools/openapi-generator#2---getting-started) using the [native Java HTTP client](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/java.md)
  ```
  java -jar openapi-generator-cli.jar generate \
    -i https://raw.githubusercontent.com/FIWARE/specifications/master/OpenAPI/ngsiv2/ngsiv2-openapi.json \
    -g java \
    -o openapi-generator-native \
    --additional-properties library=native
  ```

## [apimatic-codegen](https://www.apimatic.io/)
* [NGSI v2 API Blueprint](https://github.com/telefonicaid/fiware-orion/blob/master/doc/apiary/v2/fiware-ngsiv2-2.0-2018_09_15.apib) (2018_09_15)
* [APIMatic CodeGen](https://www.apimatic.io/)

## Disclaimer
The SDKs have been automatically generated and may not work as intended out-of-the-box!<br>
