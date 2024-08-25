# TP2 Java Spring Application

## Project Overview

This Spring Boot application is designed to manage medical consultations, patients, and appointments. It leverages Spring Data JPA with Hibernate for ORM and utilizes an H2 database in development environments for performing CRUD operations on entities such as patients, consultations, and medical staff.

## Features

- **Entity Management**: Handles entities including `Medecin`, `Patient`, `Consultation`, `RendezVous`, `Role`, and `User`.
- **Repository Layer**: Provides JPA repositories for each entity to abstract complex SQL queries.
- **Service Layer**: Implements business logic through services such as `HospitalService` and `UserService`.
- **Controller Layer**: Exposes RESTful endpoints through `PatientRestController` and `UserController` to interact with front-end applications.

## Getting Started

### Prerequisites

- Java 11 or newer
- Maven for dependency management
- XAMPP (or any environment providing MySQL for production) and H2 Database for development testing

### Running the Application

1. Start your XAMPP Control Panel and ensure that Apache and MySQL are running for production testing.
2. Clone this repository to your local machine:
   ```
   git clone https://github.com/anasbounaiim/TP2_java_spring.git
   ```
3. Navigate into the project directory:
   ```
   cd TP2_java_spring
   ```
4. Run the application using Maven:
   ```
   mvn spring-boot:run
   ```

The application should now be running on `http://localhost:8080`.

## Configuration

The application's configuration can be found in `application.properties`, located under `src/main/resources`. Adjust the database connection settings according to your local or cloud-based environment. Ensure to switch between MySQL and H2 database configurations as per your development or production needs.

