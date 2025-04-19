# 🛍️ Category-Product Management - Spring Boot Project

This is a Spring Boot project demonstrating a **One-to-Many relationship** between `Category` and `Product` entities using **Spring Data JPA** and **Hibernate**.

## 🚀 Features

- Create, Read, Update, Delete (CRUD) operations for Category and Product
- One-to-Many relationship: One Category → Many Products
- Uses Spring Boot, JPA, Hibernate
- RESTful API design
- MySQL database integration

## 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## 🔁 Relationship

- A **Category** can have multiple **Products**
- A **Product** belongs to one **Category**


## ⚙️ Configuration

### `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
