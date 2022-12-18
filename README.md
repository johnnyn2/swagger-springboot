## About
A demo project to show how to use Swagger3 to generate API interaces and models in Spring boot from OpenApi 3 specification.

## OpenApi
```java
src/main/resources/product.yml
```

## Generate source code from OpenAPI spec
```shell
./mvnw clean compile
```

## Custom the generated sources
- update the pom.xml configuration options for openapi-generator-maven-plugin

## Run the project
```shell
./mvnw spring-boot:run
```
- you may use postman to access the api endpoints listed in the product.yml api
