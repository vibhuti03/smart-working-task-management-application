# 🚀 Smart Working Task Management - Backend

A Spring Boot backend application providing REST APIs for managing tasks with full CRUD functionality.

---

## 🧠 Overview

This backend powers a Task Management application that allows users to:

* Create tasks
* View all tasks
* View task details
* Update tasks
* Toggle completion status
* Delete tasks

The application follows a layered architecture with **Controller → Service → Repository** separation for clean and
maintainable code.

---

## 🛠️ Tech Stack

* **Java 21**
* **Spring Boot**
* **Spring Web (REST APIs)**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Lombok**
* **JUnit + Mockito (for testing)**

---

## 📂 Project Structure

```
com.smartworking.taskmanager
│
├── controller        # REST Controllers
├── service           # Business logic
├── repository        # JPA repositories
├── dto               # Request & Response DTOs
├── entity            # Database entities
└── config            # Configuration files
```

---

## ⚙️ Setup Instructions

### 🔹 1. Clone the repository

```bash
git clone https://github.com/vibhuti03/smart-working-task-management-application.git
cd smart-working-task-management-application
```

---

### 🔹 2. Configure Database

Update `src/main/resources/application.properties`:

#### ✅ MySQL example

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 🔹 3. Run the application

#### Using Maven wrapper:

```bash
./mvnw spring-boot:run
```

#### OR using Maven:

```bash
mvn spring-boot:run
```

---

### 🌐 Server runs at:

```
http://localhost:8080
```

---

## 🔗 API Endpoints

📬 Postman Collection

A Postman collection is included to help you quickly test all APIs.

### 🩺 Health Check

```
GET /api/v1/health?name=Vibhuti
```

---

### 📋 Get All Tasks

```
GET /api/v1/task
```

---

### ➕ Add Task

```
POST /api/v1/add-task
```

**Request Body:**

```json
{
  "title": "Exercise",
  "description": "Need to exercise",
  "isCompleted": false,
  "dueDate": "2026-02-02T20:30:00"
}
```

---

### 🔍 Get Task Details

```
POST /api/v1/task-details?id=1
```

---

### ✏️ Update Task

```
POST /api/v1/update-task
```

**Request Body:**

```json
{
  "id": 1,
  "title": "Updated Task",
  "description": "Updated description",
  "dueDate": "2026-02-02T20:30:00",
  "isCompleted": false
}
```

---

### 🔄 Update Task Status

```
POST /api/v1/update-task-status?id=1&newStatus=true
```

---

### ❌ Delete Task

```
DELETE /api/v1/delete-task?id=1
```

---

## 🧪 Running Tests

```bash
mvn test
```

---

## 🧠 Design Highlights

* DTO-based architecture (clean separation)
* Service layer abstraction
* RESTful endpoints
* Validation using `@Valid`
* Scalable and extendable structure

---

## 🚀 Future Enhancements

* Authentication (JWT)
* Pagination & filtering
* Logging & monitoring
* Dockerization
* CI/CD pipeline

---

## 👨‍💻 Author

**Vibhuti Maheshwari**

---

## ⭐ Support

If you like this project, consider giving it a ⭐ on GitHub!
