# REST Starter

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.7-brightgreen)
![Maven](https://img.shields.io/badge/Maven-4.x-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.x-blue)
![Swagger](https://img.shields.io/badge/OpenAPI-3-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A professional RESTful API built with Spring Boot that demonstrates modern backend development practices.

This project was developed as part of a backend portfolio to showcase clean architecture, REST principles, validation, exception handling, filtering, pagination, sorting and automated testing.

---

# Features

- RESTful API
- Complete CRUD operations
- Layered Architecture
- DTO Pattern
- Request Validation
- Global Exception Handling
- Dynamic Filtering (Specifications)
- Pagination
- Sorting
- Swagger / OpenAPI Documentation
- Unit Tests
- H2 Test Database
- Docker Support
- MySQL Support

---

# Tech Stack

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 4.0.7 |
| Spring Web MVC | 4.0.7 |
| Spring Data JPA | 4.0.7 |
| Spring Validation | 4.0.7 |
| Maven | 4.x |
| MySQL | 8.x |
| H2 | Latest |
| Swagger / OpenAPI | 3 |
| Lombok | Latest |
| Docker | Latest |

---

# Highlights

✔ Clean architecture

✔ DTO pattern

✔ Global exception handling

✔ Validation

✔ Pagination

✔ Sorting

✔ Dynamic Specifications

✔ Swagger

✔ Unit testing

✔ Docker

✔ Environment variables

✔ Ready for cloud deployment

---

# Architecture

This project follows the Layered Architecture pattern.

```
Controller ➙ Service ➙ Repository ➙ Database
```

Each layer has a single responsibility.

| Layer | Responsibility |
|--------|----------------|
| Controller | Handles HTTP requests and responses |
| Service | Business logic |
| Repository | Data access |
| DTO | Request / Response models |
| Mapper | Entity ↔ DTO conversion |
| Specification | Dynamic filtering |
| Exception | Global error handling |

---

# Project Structure

```
└── REST_Starter/
    ├── src/main/java/
    │   ├── config
    │   ├── controller
    │   ├── dto/
    │   │   ├── request
    │   │   └── response
    │   ├── entity
    │   ├── exception
    │   ├── mapper
    │   ├── repository
    │   ├── service/
    │   │   └── impl
    │   ├── specification
    │   └── RestStarterApplication.java
    ├── src/main/resources/
    │   └── application.properties
    ├── src/test/java/
    │   └── com.rest_starter/
    │       ├── controller
    │       ├── service
    │       └── RestStarterApplicationTest.java
    └── src/test/resources/
        └── application-test.properties
```

---

# Requirements
- Java 21
- Maven 4+
- Docker Desktop
- MySQL (optional if using Docker)

---

# Environment Variables
Create a file named `.env` in the project root:

```
.env
```
Example:
```env
MYSQL_DATABASE=reststarter
MYSQL_USER=admin
MYSQL_PASSWORD=password
MYSQL_ROOT_PASSWORD=rootpassword
# MYSQL_PORT=3306  # Optional: only if you need to change the default port

SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/reststarter
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=password
```

---

# Running with Docker
Start the local MySQL container:
```git
docker compose up -d
```

Check containers:
```git
docker ps
```

Stop containers:
```git
docker compose down
```

---

# Running the Project
Clone repository:
```git
git clone https://github.com/huaytadev/REST_Starter.git
```

Enter project:
```git
cd REST_Starter
```

Compile:
```git
mvn clean compile
```

Run tests:
```git
mvn test
```

Package:
```git
mvn clean package
```
Run:
```git
mvn spring-boot:run
```


**Or simply open the project in Eclipse IDE and run the application as a Spring Boot App.**


The API will be available at:
```
http://localhost:8080
```

Swagger UI:
```
http://localhost:8080/swagger-ui.html
```

or

```
http://localhost:8080/swagger-ui/index.html
```

---
# API Endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | /api/products | Create product |
| GET | /api/products | Get products |
| GET | /api/products/{id} | Get product by id |
| PUT | /api/products/{id} | Replace product |
| PATCH | /api/products/{id} | Partial update |
| DELETE | /api/products/{id} | Delete product |

---

# Filtering
Examples:

| Method | Endpoint |
| --- | --- |
| GET | /api/products?category=Peripherals |
| GET | /api/products?active=true |
| GET | /api/products?minPrice=100 |
| GET | /api/products?maxPrice=500 |
| GET | /api/products?name=keyboard |

Filters can be combined.

---

# Pagination

| Method | Endpoint |
| --- | --- |
| GET | /api/products?page=0&size=10 |

---

# Sorting

| Direction | Method | Endpoint |
| --- | --- | --- |
| Ascending | GET | /api/products?sort=price,asc |
| Descending | GET | /api/products?sort=price,desc |

---

# Testing
The project contains unit tests for:

- Controller Layer
- Service Layer

Tests use:

- JUnit 5
- Mockito
- MockMvc
- H2 Database

Run all tests
```git
mvn test
```

---

# Design Decisions

This project intentionally uses:

- Layered Architecture

- DTO Pattern

- Manual Mapping

- Spring Specifications

- Global Exception Handler

- ResponseEntity

- Validation API

The objective was to keep the project simple while following production-ready practices commonly used in Spring Boot applications.

---

## Railway Deployment

To deploy this application on Railway:

1. Create a new **MySQL** service.
2. Create a new **Java** service connected to this repository.
3. Configure the following environment variables:

| Variable | Description |
|----------|-------------|
| `DB_URL` | JDBC connection URL |
| `DB_USERNAME` | Database username |
| `DB_PASSWORD` | Database password |

Example:

```text
DB_URL=jdbc:mysql://mysql.railway.internal:3306/railway
DB_USERNAME=root
DB_PASSWORD=your_password
```

The application reads these values from `application.properties`, allowing the same build to run locally or in production without code changes.

After deployment the API documentation will be available at:

```
https://YOUR_APP.up.railway.app/swagger-ui.html
```

or

```
https://YOUR_APP.up.railway.app/swagger-ui/index.html
```

depending on the Springdoc version.

This project already includes reverse proxy support:

```properties
server.forward-headers-strategy=framework
```

This configuration allows Spring Boot to correctly detect HTTPS when running behind Railway's reverse proxy.

---

# Project Goals

This project was created to demonstrate a solid foundation for building REST APIs with Spring Boot.

Rather than focusing on complex business rules, the goal is to showcase clean architecture, maintainability and commonly adopted backend practices.

---

# Version

Current version

`v1.0.0`

---

# Author

Kevin Huayta

Backend Developer

Java • Spring Boot • REST APIs

---

# License

This project is licensed under the MIT License.
