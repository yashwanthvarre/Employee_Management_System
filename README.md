# Employee Management System

A simple Spring Boot REST API for basic CRUD operations on employee records. The application uses **Spring Boot**, **Spring Data JPA** and **Java Bean Validation** to provide a clean separation between the web layer, service layer and persistence layer.

## Features

- **RESTful endpoints** to create, read, update and delete employees.
- **DTO layer** for request/response validation (`EmployeeCreateDTO`, `EmployeeUpdateDTO`, `EmployeeDTO`).
- **Service layer** encapsulating business logic (`EmployeeService`) and mapping between DTOs and entities.
- **Repository layer** using Spring Data JPA (`EmployeeRepository`).
- **Custom exception handling** with consistent JSON error responses via `GlobalExceptionHandler`.
- **Model entity** (`Employee`) with JPA annotations.
- Built with Maven and the provided Maven wrapper (`mvnw`).

## Project Structure

```text
Employee_Management_System/
├── src/main/java/com/example/demo
│   ├── controller      → REST controller
│   ├── dto             → Data Transfer Objects
│   ├── exception       → Custom exceptions & handlers
│   ├── mapper          → Entity–DTO mapper
│   ├── model           → JPA entities
│   ├── repository      → Spring Data repositories
│   └── service         → Business logic
└── src/main/resources → Application properties (not modified)
```

### Key Components

| Layer/Component | Purpose |
| --- | --- |
| **`EmployeeController`** | Exposes REST endpoints (`GET /employees`, `GET /employees/{id}`, `POST /employees`, `PUT /employees/{id}`, `DELETE /employees/{id}`). |
| **`EmployeeService`** | Implements business logic: retrieving all employees, fetching by ID with exception handling, creating new employees, updating existing ones and deleting by ID. |
| **`EmployeeRepository`** | Extends `JpaRepository<Employee, Long>`, providing CRUD operations. |
| **`Employee`** | JPA entity representing an employee. Fields: `id` (auto-generated), `name` and `role`. |
| **DTO Classes** | `EmployeeCreateDTO`, `EmployeeUpdateDTO`, `EmployeeDTO` used to validate input and shape output. |
| **Mapper** | Converts between DTOs and `Employee` entity; updates existing entities by copying non‑null fields. |
| **GlobalExceptionHandler** | Catches exceptions (like `NotFoundException` and validation errors) and returns consistent JSON error payloads. |

## API Endpoints

| Method & Path | Description | Request Body |
| --- | --- | --- |
| `GET /employees` | Retrieve all employees. Returns a list of `EmployeeDTO`. | – |
| `GET /employees/{id}` | Retrieve a single employee by ID. Returns 404 if not found. | – |
| `POST /employees` | Create a new employee. Expects `EmployeeCreateDTO` (fields `name`, `role` – both required, 2–50 chars). | `{ "name": "John Doe", "role": "Developer" }` |
| `PUT /employees/{id}` | Update an existing employee by ID. Expects `EmployeeUpdateDTO` (fields `name`, `role` – optional, 2–50 chars). | `{ "name": "Jane Doe", "role": "Manager" }` |
| `DELETE /employees/{id}` | Delete the employee by ID. | – |

## Running the Application

1. **Prerequisites**: Java 17+ and Maven installed (or use the provided Maven wrapper).
2. **Clone the repository**:
   ```bash
   git clone https://github.com/yashwanthvarre/Employee_Management_System.git
   cd Employee_Management_System
   ```
3. **Build and run**:
   ```bash
   ./mvnw spring-boot:run
   ```
   The application will start on `http://localhost:8080`.

4. **Testing the API**:
   - Get all employees:
     ```bash
     curl http://localhost:8080/employees
     ```
   - Create a new employee:
     ```bash
     curl -X POST -H "Content-Type: application/json" \
       -d '{"name":"Alice","role":"Engineer"}' \
       http://localhost:8080/employees
     ```

## Contributing

1. Fork the repo and create a branch (`git checkout -b feature/fooBar`).
2. Commit your changes (`git commit -am 'Add some feature'`).
3. Push to the branch (`git push origin feature/fooBar`).
4. Open a pull request.

## License

This project currently has no explicit license file. If you plan to use the code, consider contacting the repository owner for clarification.
