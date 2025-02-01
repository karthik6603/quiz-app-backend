# Quiz App Backend

Backend for the quiz application built with Spring Boot.

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

