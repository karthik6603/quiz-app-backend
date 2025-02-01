# Quiz App Backend

Backend for the quiz application built with Spring Boot.

[![Java](https://img.shields.io/badge/Java-11%2B-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5%2B-green)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-blue)](https://www.mysql.com/)
[![Quiz App](https://img.shields.io/badge/Quiz%20App-v1.0.0-brightgreen)](https://github.com/karthik6603/quiz-app-backend)

Welcome to the **Quiz App Backend** repository! This project implements the backend for a quiz application using a microservices architecture. It leverages several modern Java technologies and frameworks to deliver a scalable and robust system.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Microservices](#microservices)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Testing with Postman](#testing-with-postman)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Overview

The **Quiz App Backend** is a backend application for a quiz system built with Java and Spring Boot. It uses a microservices architecture to separate the business logic into two main services:

- **Question Service:** Manages quiz questions.
- **Quiz Service:** Manages quizzes, which include requesting quiz questions and scoring.

Additional components include service discovery with Eureka, inter-service communication using Feign clients, an API Gateway for routing, and persistent data management with Spring Data JPA and MySQL. The backend runs on an embedded Tomcat server.

## Technologies Used

- **Java**
- **Spring Boot**
- **Microservices Architecture**
- **Eureka Server (Service Discovery)**
- **Feign Client (Inter-service Communication)**
- **API Gateway**
- **Embedded Tomcat**
- **Spring Data JPA**
- **MySQL**
- **Postman** (for API testing)

## Architecture

The architecture is designed for scalability and maintainability. The key components include:

- **API Gateway:** Routes requests to the appropriate microservices.
- **Eureka Server:** Handles service discovery for dynamic microservice registration.
- **Question Service:** Exposes endpoints to create, update, retrieve, and delete quiz questions.
- **Quiz Service:** Manages quizzes, interacts with the Question Service via a Feign client, and handles quiz logic.

## Microservices

### 1. Question Service

- **Responsibilities:**  
  - Manage CRUD operations for quiz questions.
  - Provide endpoints for question creation, modification, deletion, and retrieval.

- **Key Components:**  
  - Spring Boot Application
  - JPA Repositories for data access
  - REST Controllers

### 2. Quiz Service

- **Responsibilities:**  
  - Manage quizzes, including quiz creation and question aggregation.
  - Communicate with the Question Service using a Feign client.

- **Key Components:**  
  - Spring Boot Application
  - JPA Repositories for data access
  - REST Controllers
  - Feign Client for inter-service communication

## Getting Started

### Prerequisites

Before running this project, ensure you have the following installed:

- **Java 11** or later
- **Maven** (or your preferred build tool)
- **MySQL Server**
- **Git**

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/karthik6603/quiz-app-backend.git
   cd quiz-app-backend
   ```

2. **Build the Project:**

   ```bash
   mvn clean install
   ```

### Configuration

1. **Set Up the Database:**

   - Create a new MySQL database named `quiz_app_db`.
   - Configure your `application.properties` or `application.yml` file with the correct database credentials:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/quiz_app_db
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
     ```

## Running the Application

1. **Start MySQL Server.**
2. **Run the Application:**

   ```bash
   mvn spring-boot:run
   ```

3. **Access the APIs:**

   - API Gateway: `http://localhost:8080`
   - Eureka Server: `http://localhost:8761`
   - Question Service: `http://localhost:8081`
   - Quiz Service: `http://localhost:8082`

## Testing with Postman

1. Import the Postman collection (if available) to quickly test the APIs.
2. Manually test endpoints such as:
   - `POST /questions` - Add a new question.
   - `GET /questions` - Retrieve all questions.
   - `POST /quizzes` - Create a new quiz.
   - `GET /quizzes/{id}` - Get quiz details.

## Project Structure

```
quiz-app-backend/
│-- question-service/
│   │-- src/main/java/com/quiz/question/
│-- quiz-service/
│   │-- src/main/java/com/quiz/quiz/
│-- api-gateway/
│-- eureka-server/
│-- pom.xml
│-- README.md
```

## Contributing

Contributions are welcome! Follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`feature-branch-name`).
3. Commit your changes with meaningful messages.
4. Push to your forked repository.
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or support, feel free to reach out:

- **Email:** karthik.p6603@gmail.com
- **GitHub:** [karthik6603](https://github.com/karthik6603)
- **LinkedIn:** [Profile](https://linkedin.com/in/karthik6603)

Happy coding! 🚀

