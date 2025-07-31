# 📚 Simple Library Management API

A Spring Boot application for managing book borrowings and returns in a library system.

---

## 🚀 Features

- REST APIs for:
    - Register a new borrower to the library.
    - Register a new book to the library.
    - Get a list of all books in the library.
- JPA-based persistence
  - H2 for Local development testing
  - MySql for Dev and Production Environment
- Swagger UI for API documentation
  - http://localhost:8080/swagger-ui/index.html
- Enum-based status handling for loan records
  - BORROWED
  - RETURNED
- Global exception handling with `@ControllerAdvice`
- Profiles for local, dev, and prod environments

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3.2.4
- Spring Data JPA
- H2 (or MySQL)
- Lombok
- Swagger (springdoc-openapi)
- Maven

---

## 🏁 Getting Started

### 🔧 Prerequisites

- Java 21
- Maven 3.6+

### 🏗️ Build & Run

```bash
# Clone the repo
git clone https://github.com/sirikumara/simple-library.git
cd book-loan-api
 
#Set the correct profile(dev, prod) with application properties
  - spring.profiles.active=

# Or build and run
./mvn clean install
java -jar target/simple-library-1.0.0-SNAPSHOT.jar
