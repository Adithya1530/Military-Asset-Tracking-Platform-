# 🛡️ Military Asset Tracking Platform

A Spring Boot-based backend application designed to manage and track military assets across multiple bases. The system provides CRUD operations for assets, maintains asset type classification, and tracks asset locations through base associations. It uses a RESTful API architecture and integrates Swagger for API documentation.

---------

## ✅ Features Implemented

- **Asset Management** – Create, read, update, and delete military assets.
- **Base Association** – Link each asset to its current military base.
- **Asset Type Classification** – Categorize assets using enumerations.
- **Relational Database Integration** – Powered by MySQL with JPA and Hibernate ORM.
- **API Documentation** – Swagger UI integrated for live testing and documentation.
- **Lombok Integration** – Eliminates boilerplate code for entities and DTOs.

---------

## 🚀 Tech Stack

- **Backend** - Spring Boot ((Spring Web, Spring Data JPA))
- **Database** - MySQL
- **ORM** - Hibernate (via JPA)
- **Documentation** - Swagger (Springdoc OpenAPI)
- **Build Tool** - Maven
- **Others** - Lombok, Spring Boot DevTools

---------

## 📁 Project Structure

    src/main/java/com/adithya/MAMS
        ├── entity
        │     ├── Asset.java
        │     ├── Base.java
        │     ├── AssetType.java
        ├── controller
        │     ├── AssetController.java
        ├── service
        │     ├── AssetService.java
        ├── repository
              ├── AssetRepository.java

## 🛠️ Configure Database

Update the application.properties file with your MySQL credentials: 
spring.datasource.url=jdbc:mysql://localhost:3306/mams_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update

## 📖 API Documentation

Once the app is running, access Swagger UI at:
🔗 http://localhost:8080/swagger-ui/index.html