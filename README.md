# 📝 BlogPost REST API

A secure, production-ready REST API built with Spring Boot for creating, managing, and retrieving blog posts. Includes JWT-based authentication, validation, and Mysql database integration.

---

## 🚀 Features

- ✅ **User Registration & Login (JWT Auth)**
- 🔐 **JWT Token Generation and Validation**
- ✍️ **CRUD Operations for Blog Posts**
- 📄 **Form Validation with Custom Error Messages**
- 🗂️ **Modular Architecture (DTO, Entity, Service, Controller)**
- 🧪 **H2 DB for in-memory database**
- 🐳 **Docker Ready**
- ☁️ **Deployment on Railway**

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Security + JWT**
- **MySQL / H2**
- **Lombok**
- **Maven**
- **Postman** (for API testing)
- **AWS EC2** (for deployment)

---

## 📦 API Endpoints

### 🔐 Authentication
| Method | Endpoint              | Description            |
|--------|-----------------------|------------------------|
| POST   | `/api/users/register` | Register a new user    |
| POST   | `/api/auth/login`     | Login and get JWT token|

### 📝 BlogPost
| Method | Endpoint           | Description                      |
|--------|--------------------|----------------------------------|
| GET    | `/api/posts`       | Get all posts (secured)          |
| POST   | `/api/posts`       | Create a post (secured)          |
| GET    | `/api/posts/{id}`  | Get a post by ID (secured)       |
| PUT    | `/api/posts/{id}`  | Update a post (secured)          |
| DELETE | `/api/posts/{id}`  | Delete a post (secured)          |


