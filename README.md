<div align="center">
  <h1>REST STARTER</h1>
  <p>
    Simple REST API built with Spring Boot, PostgreSQL and modern backend development practices.
  </p>
</div>
<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange" alt="Java 21">
  <img src="https://img.shields.io/badge/Spring_Boot-4.0.7-brightgreen" alt="Spring Boot 4.0.7">
  <img src="https://img.shields.io/badge/PostgreSQL-18.x-blue" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/Maven-4.x-blue" alt="Maven">
  <img src="https://img.shields.io/badge/Docker-enabled-blue" alt="Docker">
  <img src="https://img.shields.io/badge/OpenAPI_%2F_Swagger-3-green" alt="OpenAPI / Swagger">
  <img src="https://img.shields.io/badge/JUnit-5-red" alt="JUnit 5">
  <img src="https://img.shields.io/badge/GitHub_Actions-CI-blue" alt="GitHub Actions">
  <img src="https://img.shields.io/badge/Render-deploy-purple" alt="Render">
  <img src="https://img.shields.io/badge/License-MIT-lightgrey" alt="License MIT">
</p>

<h2>ABOUT THE PROJECT</h2>

REST Starter is a simple REST API built with Spring Boot that demonstrates how to build a backend application step by step using commonly adopted development practices.

The project focuses on product management and provides complete CRUD operations, request validation, global exception handling, dynamic filtering, pagination, sorting, database migrations, automated testing, API documentation, containerization, continuous integration and cloud deployment.

The main goal is not to create a complex business application, but to provide a clear and practical example of how a simple REST API can be structured and progressively improved.

The project is also designed as a learning resource for Trainee and Junior Backend Developers who want to understand how the different components of a Spring Boot REST API work together.

<br>

<h2>WHAT WILL YOU LEARN?</h2>

By exploring this project, you can learn:

+ How to structure a REST API using Spring Boot.
+ How Controllers, Services and Repositories work together.
+ How to implement CRUD operations.
+ How to use DTOs for API requests and responses.
+ How to separate API models from database entities.
+ How to map entities to DTOs.
+ How to validate incoming requests.
+ How to create custom validation rules.
+ How to handle exceptions globally.
+ How to return consistent error responses.
+ How to implement dynamic filtering.
+ How to use Spring Data JPA Specifications.
+ How to implement pagination.
+ How to implement sorting.
+ How to use PostgreSQL with Spring Data JPA.
+ How to manage database changes with Flyway.
+ How to use a separate database configuration for tests.
+ How to test Controllers, Services, validations and exception handling.
+ How to document an API with OpenAPI and Swagger UI.
+ How to configure an application using environment variables.
+ How to containerize a Spring Boot application with Docker.
+ How to create a local application and PostgreSQL environment with Docker Compose.
+ How to create a Continuous Integration workflow with GitHub Actions.
+ How to deploy a Spring Boot application and PostgreSQL database to Render.
+ How to expose application health information using Spring Boot Actuator.

<br>

<h2>TECH STACK</h2>

| Technology | Purpose |
|:---|:---|
| **Java 21** | Application development |
| **Spring Boot 4.0.7** | Application framework |
| **Spring Web MVC** | REST API and HTTP handling |
| **Spring Data JPA** | Persistence and database access |
| **Jakarta Validation** | Request validation |
| **PostgreSQL** | Production database |
| **H2** | Test database |
| **Flyway** | Database migrations |
| **Springdoc OpenAPI** | API documentation |
| **Lombok** | Boilerplate reduction |
| **JUnit 5** | Testing |
| **Mockito** | Mocking dependencies |
| **MockMvc** | Controller testing |
| **Maven** | Build and dependency management |
| **Docker** | Application containerization |
| **Docker Compose** | Local application and database environment |
| **GitHub Actions** | Continuous Integration |
| **Render** | Cloud deployment |

<br>

<h2>FEATURES</h2>

+ RESTful API
+ Complete CRUD operations
+ Layered Architecture
+ DTO Pattern
+ Manual Entity-to-DTO Mapping
+ Request Validation
+ Custom Price Range Validation
+ Global Exception Handling
+ Consistent Error Responses
+ Dynamic Filtering
+ Spring Data JPA Specifications
+ Pagination
+ Sorting
+ PostgreSQL Integration
+ Flyway Database Migrations
+ Dedicated Test Profile
+ H2 Database for Tests
+ Controller Tests
+ Service Tests
+ Validation Tests
+ Exception Handler Tests
+ Actuator Health and Info Endpoints
+ OpenAPI / Swagger Documentation
+ Environment-based Configuration
+ Docker Support
+ Docker Compose
+ GitHub Actions CI
+ Render Deployment

<br>

<h2>ARCHITECTURE</h2>

The application follows a Layered Architecture.
The main request flow is:

<div align="center">
  <img src="https://raw.githubusercontent.com/huaytadev/assets/b9f3d49743ab864226af38cbe173ee76d8a37c2d/assets/Diagrama%20de%20capas.svg" alt="Diagram" width="1000">
</div>
<br>

Aditional components are used to keep responsabilities separated:

<div align="center">
  <img src="https://raw.githubusercontent.com/huaytadev/assets/b53b7ced1b925d03ef34c1ebb3a3cab9bb9a156d/assets/Diagrama%20de%20componentes%20adicionales.svg" alt="Diagram" width="1200">
</div>
<br>

The main layers and responsibilities are:

| Layer | Responsability |
|:---|:---|
| **Controller** | Handles HTTP requests, validates input and returns HTTP responses |
| **Service** | Contains application and business logic |
| **Repository** | Handles persistences and database access |
| **DTO** | Defines the data exchanged through the API |
| **Mapper** | Converts between DTOs and entities |
| **Specification** | Builds dynamic database filters |
| **Entity** | Represents the database model |
| **Exception** | Handles application errors globally |
| **Validation** | Contains custom validation rules |
| **Config** | Contains application configuration such as OpenAPI |

<br>

<h2>PROJECT STRUCTURE</h2>

```

REST_Starter/
├── .github/
│   └── workflows/
│       └── ci.yml
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/rest_starter/
│   │   │       ├── config/
│   │   │       │   └── OpenApiConfig.java
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   └── ProductController.java
│   │   │       │
│   │   │       ├── dto/
│   │   │       │   ├── request/
│   │   │       │   │   ├── CreateProductRequest.java
│   │   │       │   │   ├── PatchProductRequest.java
│   │   │       │   │   ├── ProductFilterRequest.java
│   │   │       │   │   └── UpdateProductRequest.java
│   │   │       │   │
│   │   │       │   └── response/
│   │   │       │       ├── ErrorResponse.java
│   │   │       │       ├── PageResponse.java
│   │   │       │       └── ProductResponse.java
│   │   │       │
│   │   │       ├── entity/
│   │   │       │   └── Product.java
│   │   │       │
│   │   │       ├── exception/
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── ResourceNotFoundException.java
│   │   │       │
│   │   │       ├── mapper/
│   │   │       │   └── ProductMapper.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   └── ProductRepository.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   ├── ProductService.java
│   │   │       │   └── impl/
│   │   │       │       └── ProductServiceImpl.java
│   │   │       │
│   │   │       ├── specification/
│   │   │       │   └── ProductSpecification.java
│   │   │       │
│   │   │       ├── validation/
│   │   │       │   ├── PriceRangeValidator.java
│   │   │       │   └── ValidPriceRange.java
│   │   │       │
│   │   │       └── RestStarterApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/
│   │           └── migration/
│   │               └── V1__create_products_table.sql
│   │
│   └── test/
│       ├── java/
│       │   └── com/rest_starter/
│       │       ├── actuator/
│       │       │   └── ActuatorEndpointTest.java
│       │       ├── controller/
│       │       │   └── ProductControllerTest.java
│       │       ├── exception/
│       │       │   └── GlobalExceptionHandlerTest.java
│       │       ├── service/
│       │       │   └── ProductServiceImplTest.java
│       │       ├── validation/
│       │       │   └── ProductValidationTest.java
│       │       └── RestStarterApplicationTests.java
│       │
│       └── resources/
│           └── application-test.properties
│
├── .dockerignore
├── .gitignore
├── Dockerfile
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

```

<br>

<h2>ARCHITECTURE</h2>

The API is based on a Product resource.

Base URL:

```
/api/products
```

Endpoint | HTTP Method | Description
| :--- | :---: | :--- |
/api/products | POST | Create a product
/api/products | GET | Get a paginated list of products
/api/products/{id} | GET | Get a product by ID
/api/products/{id} | PUT | Fully update a product
/api/products/{id} | PATCH | Partially update a product
/api/products/{id} | DELETE | Delete a product

<br>

<h2>PRODUCT RESOURCE</h2>

A product contains the following fields:

Field | Type | Description
| :--- | :---: | :--- |
id | Long | Unique product identifier
name | String | Product name
description | String | Product description
price | BigDecimal | Product price
stock | Integer | Available stock
category | String | Product category
active | Boolean | Indicates whether the product is active
createdAt | Instant | Creation timestamp
updatedAt | Instant | Last update timestamp

<br>

<h2>CREATE A PRODUCT</h2>

<h3>Endpoint:</h3>

```
POST /api/products
```

<h3>Example request:</h3>

```json
{
    "name": "Mechanical Keyboard", 
	"description": "RGB mechanical keyboard with blue switches", 
	"price": 129.99, 
	"stock": 25, 
	"category": "Peripherals" 
}
```

<h3>Successful response:</h3>

```
201 Created
```

<h3>Example Response:</h3>

```json
{ 
	"id": 1, 
	"name": "Mechanical Keyboard", 
	"description": "RGB mechanical keyboard with blue switches", 
	"price": 129.99, 
	"stock": 25, 
	"category": "Peripherals", 
	"active": true, 
	"createdAt": "2026-09-18T12:00:00Z", 
	"updatedAt": "2026-09-18T12:00:00Z"
}
```

<br>

<h2>GET PRODUCT BY ID</h2>

<h3>Endpoint:</h3>

```
GET /api/products/{id}
```

<h3>Example:</h3>

```
GET /api/products/1
```

<h3>Successful response:</h3>

```
200 OK
```

<h3>If the product does not exist, the API returns:</h3>

```
404 Not Found
```

<br>

<h2>UPDATE A PRODUCT</h2>

PUT is used when all editable fields are provided.

<h3>Endpoint:</h3>

```
PUT /api/products/{id}
```

<h3>Example request:</h3>

```json
{
  "name": "Mechanical Keyboard Pro",
  "description": "Updated RGB mechanical keyboard",
  "price": 149.99,
  "stock": 15,
  "category": "Peripherals",
  "active": true
}
```

<h3>Successful response:</h3>

```
200 OK
```

<br>

<h2>PARTIAL UPDATE</h2>

PATCH is used when only specific fields need to be changed.

<h3>Endpoint:</h3>

```
PATCH /api/products/{id}
```

<h3>Example request:</h3>

```json
{
  "price": 139.99, 
  "stock": 20 
}
```

Only the provided fields are updated.

<h3>Successfull response:</h3>

```
200 ok
```

<br>

<h2>DELETE A PRODUCT</h2>

<h3>Endpoint:</h3>

```
DELETE /api/products/{id}
```

<h3>Example:</h3>

```
DELETE /api/products/1
```

<h3>Successful response:</h3>

```
204 No Content
```

<br>

<h2>REQUEST VALIDATION</h2>

The API validates incoming requests using Jakarta Validation.

<h3>Examples of validation rules include:</h3>

+ Product name is required
+ Product name cannot exceed 100 characters
+ Product description cannot exceed 500 characters
+ Product price is required when creating or fully updating a product
+ Product price must be at least 0.01
+ Stock is required when creating or fully updating a product
+ Stock cannot be negative
+ Product category is required when creating or fully updating a product
+ Product category cannot exceed 80 characters
+ Product ID must be greater than zero
+ Filter prices must be greater than or equal to 0.01

<br>

<h2>CUSTOM VALIDATION</h2>

The project also includes a custom validation rule for product price filtering.

<h3>The following annotation is used:</h3>

```
@ValidPriceRange
```

<h3>This validation ensures that:</h3>

```
minPrice <= maxPrice
```

<h3>For example, this is valid:</h3>

```
minPrice=50
maxPrice=200
```

<h3>While this is invalid:</h3>

```
minPrice=200
maxPrice=50
```

<h3>The custom validation is implemented using:</h3>

```
ValidPriceRange
PriceRangeValidator
```

<br>

<h2>EXCEPTION HANDLING</h2>

The API uses a global exception handler through Spring's exception handling mechanism.

<h3>The main component responsible for this behavior is:</h3>

```
GlobalExceptionHandler
```

Instead of handling exceptions individually inside every Controller method, errors are handled centrally.

<h3>The API provides a consistent error structure:</h3>

```json
{
  "timestamp": "2026-09-18T12:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Product not found with id: 1",
  "path": "/api/products/1",
  "validationErrors": null
}
```

<h3>The application handles several common error scenarios, including:</h3>

+ Resource not found
+ Validation errors
+ Database constraint violations
+ Illegal arguments
+ Invalid parameter types
+ Unexpected internal errors

<br>

<h2>VALIDATION ERROR RESPONSE</h2>

For validation failures, the response can include field-level errors.

<h3>Example:</h3>

```json
{
  "timestamp": "2026-09-18T12:00:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/api/products",
  "validationErrors": {
    "name": "Product name is required",
    "price": "Product price must be greater than 0"
  }
}
```

<br>

<h2>FILTERING</h2>

The GET products endpoint supports dynamic filtering.

<h3>Available filters:</h3>

Filter | Example
|---|---|
name | /api/products?name=keyboard
category | /api/products?category=Peripherals
minPrice | /api/products?minPrice=50
maxPrice | /api/products?maxPrice=200
active | /api/products?active=true

Filters can be combined.

<h3>Example:</h3>

```
GET /api/products?category=Peripherals&minPrice=50&maxPrice=200&active=true
```

The filtering logic is implemented using Spring Data JPA Specifications.

<h3>The main component responsible for this functionality is:</h3>

```
ProductSpecification
```

<br>

<h2>HOW FILTERING WORKS</h2>

<h3>The Controller receives the filter parameters through:</h3>

```
ProductFilterRequest
```

<h3>The Service passes the filter information to:</h3>

```
ProductSpecification
```

The Specification dynamically builds the required database predicates.

This allows the application to support multiple optional filters without creating a separate Repository method for every possible combination.

<br>

<h2>PAGINATION</h2>

The API supports pagination through Spring Data's Pageable abstraction.

<h3>Example:</h3>

```
GET /api/products?page=0&size=10
```

<h3>The default configuration is:</h3>

```
page = 0
size = 10
sort = id,asc
```

The API returns pagination metadata together with the product collection.

<h3>Example:</h3>

```json
{
  "content": [
    {
      "id": 1,
      "name": "Mechanical Keyboard",
      "price": 129.99
    }
  ],
  "page": 0,
  "size": 10,
  "totalElements": 25,
  "totalPages": 3,
  "first": true,
  "last": false
}
```

<h3>The pagination response is represented by:</h3>

```
PageResponse<T>
```

<br>

<h2>SORTING</h2>

Products can also be sorted using Spring Data's sorting parameters.

<h3>Ascending order:</h3>

```
GET /api/products?sort=price,asc
```

<h3>Descending order:</h3>

```
GET /api/products?sort=price,desc
```

Sorting can also be combined with pagination and filtering.

<h3>Example:</h3>

```
GET /api/products?category=Peripherals&page=0&size=10&sort=price,desc
```

<br>

<h2>DATABASE</h2>

The application uses PostgreSQL as its production database.

The database configuration is provided through environment variables rather than being hard-coded into the application.

<h3>The main database properties are:</h3>

```properties
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
```

<h3>JPA is configured with:</h3>

```properties
spring.jpa.hibernate.ddl-auto=validate
```

This means Hibernate validates the existing database schema instead of automatically creating or modifying database tables.

<br>

<h2>DATABASE MIGRATIONS</h2>

Database schema changes are managed using Flyway.

<h3>Migration files are located in:</h3>

```
src/main/resources/db/migration/
```

<h3>Current migration:</h3>

```
V1__create_products_table.sql
```

<h3>The initial migration creates the products table and defines database-level constraints such as:</h3>

+ Primary key
+ Required fields
+ Maximum field lengths
+ Non-negative stock
+ Minimum product price
+ Default active status

<br>

<h2>WHY FLYWAY?</h2>

Using database migrations provides a controlled and versioned way to manage schema changes.

Instead of relying on Hibernate to automatically modify the production database, schema changes are explicitly defined through migration files.

This makes database changes easier to track, reproduce and deploy consistently across environments.

<br>

<h2>TEST DATABASE</h2>

Tests use an H2 in-memory database instead of the PostgreSQL production database.

<h3>The test configuration is located at:</h3>

```
src/test/resources/application-test.properties
```

<h3>The test profile configures:</h3>

```
H2 in-memory database
Hibernate create-drop
H2 dialect
```

This allows tests to run without requiring a PostgreSQL server to be running locally.

<br>

<h2>TESTING</h2>

The project includes automated tests covering several parts of the application.

<h3>Current test areas include:</h3>

+ Application context
+ Product Controller
+ Product Service
+ Global Exception Handler
+ Product Validation
+ Actuator endpoints

<h3>Test classes:</h3>

```
RestStarterApplicationTests
ProductControllerTest
ProductServiceImplTest
GlobalExceptionHandlerTest
ProductValidationTest
ActuatorEndpointTest
```

<h3>The tests use:</h3>

+ JUnit 5
+ Mockito
+ MockMvc
+ Spring Boot Test
+ H2

<br>

<h2>RUN TESTS</h2>

<h3>Using the Maven Wrapper:</h3>

```
./mvnw test
```

<h3>On Windows:</h3>

```
mvnw.cmd test
```

The Maven Wrapper allows the project to use the configured Maven version without requiring Maven to be installed globally.

<br>

<h2>API DOCUMENTATION</h2>

The API is documented using OpenAPI and Swagger UI.

<h3>Local Swagger UI:</h3>

```
http://localhost:8080/swagger-ui/index.html
```

The API documentation describes the available endpoints, request parameters, request bodies and response models.

<h3>The Controller methods also contain OpenAPI annotations such as:</h3>

```
@Operation
@Parameter
@Tag
```

This keeps the API documentation close to the code that defines the API behavior.

<h2>ENVIRONMENT VARIABLES</h2>

The application uses environment variables for database configuration.

<h3>Required variables:</h3>

```properties
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
```

<h3>For local Docker development, these values can be stored in a:</h3>

```
.env
```

file in the project root.

<h3>Example structure:</h3>

```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/reststarter
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
```

Do not commit real credentials or sensitive environment variables to the repository.

The **.env** file should remain local and should be included in .gitignore.

<br>

<h2>RUNNING LOCALLY</h2>

<h3>Requirements:</h3>

+ Java 21
+ Git
+ Docker Desktop

Maven does not need to be installed globally because the project includes the Maven Wrapper.

<br>

<h2>CLONE THE REPOSITORY</h2>

```
git clone https://github.com/huaytadev/REST_Starter.git
```

<h3>Enter the project directory:</h3>

```
cd REST_Starter
```

<br>

<h2>RUN WITH MAVEN</h2>

<h3>Start the application:</h3>

```
./mvnw spring-boot:run
```

<h3>On Windows:</h3>

```
mvnw.cmd spring-boot:run
```

<h3>The application will be available at:</h3>

```
http://localhost:8080
```

<br>

<h2>BUILD THE PROJECT</h2>

```
./mvnw clean package
```

<h3>To build without running tests:</h3>

```
./mvnw clean package -DskipTests
```

<br>

<h2>RUN WITH DOCKER COMPOSE</h2>

The project includes Docker Compose to run both the Spring Boot application and PostgreSQL locally.

<h3>Start the containers:</h3>

```
docker compose up -d
```

<h3>Check the running containers:</h3>

```
docker ps
```

<h3>Stop the containers:</h3>

```
docker compose down
```

<h3>The application will be available at:</h3>

```
http://localhost:8080
```

<h3>PostgreSQL will be exposed locally through:</h3>

```
localhost:5432
```

<br>

<h2>DOCKER</h2>

The project includes a multi-stage Dockerfile.

<h3>The first stage is responsible for building the application:</h3>

<div align="center">

```
Maven + Java 21
|
|
v
Application JAR
```

</div>

<h3>The second stage uses a Java 21 runtime image:</h3>

<div align="center">

```
Java 21 JRE
|
|
v
Application JAR
```

</div>

The final image contains only what is necessary to run the application.

This approach keeps the runtime image smaller than an image containing the complete build environment.

<br>

<h2>DOCKER COMPOSE ARCHITECTURE</h2>

The local Docker Compose environment contains two services:

<div align="center">

```
backend-network
|
+------------+------------+
|                         |
v                         v
REST Starter               PostgreSQL
 port 8080                 port 5432
```

</div>
The application waits for PostgreSQL to become healthy before starting.

A PostgreSQL health check is configured in Docker Compose using pg_isready.

<br>

<h2>CONTINUOUS INTEGRATION</h2>

<h3>The project includes a GitHub Actions workflow:</h3>

```
.github/workflows/ci.yml
```

<h3>The workflow runs for pushes and pull requests targeting:</h3>

```
main
develop
```

<h3>The CI pipeline performs the following steps:</h3>

<div align="center">

```
Checkout repository
|
v
Set up JDK 21
|
v
Run tests
|
v
Build application
```

</div>

The Maven dependency cache is also enabled through the GitHub Actions Java setup.

<br>

<h2>DEPLOYMENT</h2>

The application is deployed to Render.

<h3>The production environment consists of:</h3>

<div align="center">

```
GitHub Repository
|
v
Render
|
+----------------------+
|                      |
v                      v
Spring Boot API          PostgreSQL
```

</div>

The PostgreSQL database is also hosted on Render.

Production database credentials are configured through Render environment variables.

The application itself does not contain production database credentials in the source code.

<br>

<h2>PRODUCTION CONFIGURATION</h2>

<h3>The production application receives the following environment variables:</h3>

```properties
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
```

The same application configuration can therefore be used across different environments without modifying the source code.

<br>

<h2>LIVE APPLICATION</h2>

<h3>Live API:</h3>

```
https://rest-starter.onrender.com/
```

<h3>Swagger UI:</h3>

```
https://rest-starter.onrender.com//swagger-ui/index.html
```

<h3>Health endpoint:</h3>

```
https://rest-starter.onrender.com//actuator/health
```

<br>

<h2>MONITORING AND HEALTH</h2>

Spring Boot Actuator is included in the project.

The application exposes the following Actuator endpoints:

```
/actuator/health
/actuator/info
```

The health endpoint can be used to verify whether the application is running.

<h3>Example:</h3>

```
GET /actuator/health
```

<h3>Example response:</h3>

```json
{
  "status": "UP"
}
```

The info endpoint exposes basic application information configured through Spring Boot.

<br>

<h2>DESIGN DECISIONS</h2>

The project intentionally follows several practices commonly used when developing REST APIs with Spring Boot.

<h3>Layered Architecture</h3>

Responsibilities are separated between Controllers, Services and Repositories.

<h3>DTO Pattern</h3>

The API does not expose the JPA entity directly. Request and response DTOs define the API contract.

<h3>Manual Mapping</h3>

A dedicated mapper is used to convert between entities and DTOs.

<h3>Global Exception Handling</h3>

Application errors are handled centrally through GlobalExceptionHandler.

<h3>Validation</h3>

Incoming data is validated before reaching the business logic.

<h3>Spring Data Specifications</h3>

Dynamic filtering is implemented using Specifications instead of creating many Repository methods for different filter combinations.

<h3>Pagination and Sorting</h3>

Spring Data Pageable is used to provide standard pagination and sorting functionality.

<h3>Database Migrations</h3>

Flyway is used to version and apply database schema changes.

<h3>Environment-based Configuration</h3>

Database credentials are provided through environment variables instead of being hard-coded.

<h3>Test Profile</h3>

Tests use a dedicated test configuration and an H2 in-memory database.

<h3>Docker</h3>

The application can be run consistently using containers.

<h3>Continuous Integration</h3>

GitHub Actions automatically runs tests and builds the application when changes are pushed or pull requests are created.

<br>

<h2>VERSION HISTORY</h2>

The project was developed progressively through multiple versions.

<h3>v1.0.0</h3>

REST API foundation.

<h4>Main concepts introduced:</h4>

+ Spring Boot project setup
+ REST API structure
+ Product resource
+ CRUD operations
+ Layered Architecture
+ Repository and Service layers

<h3>v1.1.0</h3>

Validation and error handling improvements.

<h4>Main concepts introduced:</h4>

+ DTOs
+ Request validation
+ Global exception handling
+ Consistent error responses
+ Resource not found handling

<h3>v1.2.0</h3>

Querying and testing improvements.

<h4>Main concepts introduced:</h4>

+ Dynamic filtering
+ Spring Data JPA Specifications
+ Pagination
+ Sorting
+ Automated tests
+ H2 test database
+ Dedicated test configuration

<h3>v1.3.0</h3>

Production-oriented improvements.

<h4>Main concepts introduced:</h4>

+ PostgreSQL
+ Flyway database migrations
+ Docker
+ Docker Compose
+ Spring Boot Actuator
+ OpenAPI / Swagger documentation
+ Environment-based configuration
+ GitHub Actions CI
+ Render deployment

<br>

<h2>LEARNING PATH</h2>

<h3>The project can be explored in the following order:</h3>

+ 01 - REST API fundamentals
  - Start with the Controller and understand how HTTP requests are mapped to application methods.

+ 02 - Layered Architecture
  - Follow the request from Controller to Service and Repository.

+ 03 - DTOs
  - Understand why API requests and responses are separated from JPA entities.

+ 04 - CRUD operations
  - Explore how products are created, retrieved, updated and deleted.

+ 05 - Validation 
  - Learn how Jakarta Validation is used to validate incoming data.

+ 06 - Custom validation
  - Explore the ValidPriceRange annotation and PriceRangeValidator.

+ 07 - Exception handling
  - Follow how exceptions are handled globally through GlobalExceptionHandler.

+ 08 - Filtering
  - Explore ProductFilterRequest and ProductSpecification.

+ 09 - Pagination and sorting
  - Understand how Pageable is used to control API results.

+ 10 - Database
  - Explore the Product entity and PostgreSQL configuration.

+ 11 - Database migrations
  - Explore how Flyway creates and manages the database schema.

+ 12 - Testing
  - Review Controller, Service, Validation, Exception Handler and Actuator tests.

+ 13 - API documentation
  - Explore the OpenAPI configuration and Swagger UI.

+ 14 - Docker
  - Understand how the application and PostgreSQL database can run in containers.

+ 15 - Continuous Integration
  - Review the GitHub Actions workflow.

+ 16 - Deployment
  - See how the application and database are deployed using Render.

<br>

<h2>PROJECT GOALS</h2>

The main goal of REST Starter is to demonstrate how a simple REST API can evolve from a basic CRUD application into a more complete backend project.

The project intentionally avoids unnecessary complexity and focuses on concepts that are useful when learning Spring Boot and REST API development.

Each version introduces additional concepts so that the project can be studied progressively instead of presenting all the concepts at once.

<br>

<h2>FUTURE IMPROVEMENTS

<h3>Possible future improvements include:</h3>

+ Authentication and authorization
+ Role-based access control
+ Integration tests with Testcontainers
+ Structured logging
+ Metrics
+ More advanced domain rules
+ API versioning
+ Additional resources
+ More comprehensive integration testing
+ Improved observability

<br>

<h2>AUTHOR</h2>

Kevin Huayta

Backend Developer

Java + Spring Boot + REST APIs

GitHub:
[github.com/huaytadev](https://github.com/huaytadev)

LinkedIn:
[linkedin.com/in/kevin-huayta/](https://www.linkedin.com/in/kevin-huayta/)

LICENSE

This project is licensed under the MIT License.

See the LICENSE file for more information.
