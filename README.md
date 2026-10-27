# 📘 Education Institute Management System (Smart Coaching)

[![Live Demo](https://img.shields.io/badge/Live%20Demo-Render-46E3B7.svg?logo=render)](https://education-office-management.onrender.com/)
[![Java 17](https://img.shields.io/badge/Java-17-orange.svg?logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen.svg?logo=springboot)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-6DB33F.svg?logo=springsecurity)](https://spring.io/projects/spring-security)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg?logo=mysql)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Ready-2496ED.svg?logo=docker)](https://www.docker.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A modern, full-stack **Education & Coaching Institute Management System** built with **Spring Boot 3** RESTful APIs and a responsive single-page web interface. It provides comprehensive role-based workflows for **Administrators**, **Teachers**, and **Students** to streamline academic and administrative tasks including enrollment, attendance tracking, dynamic grading/exam marks, routine management, fee payments, and announcements.

🌐 **Live Demo**: [https://education-office-management.onrender.com/](https://education-office-management.onrender.com/)  
📂 **GitHub Repository**: [https://github.com/it22030/Education-Institute-Management-Sytem](https://github.com/it22030/Education-Institute-Management-Sytem)

---

## 📑 Table of Contents

- [Features](#-features)
  - [👑 Admin Capabilities](#-admin-capabilities)
  - [👨‍🏫 Teacher Capabilities](#-teacher-capabilities)
  - [🎓 Student Capabilities](#-student-capabilities)
- [🛠️ Tech Stack](#️-tech-stack)
- [📂 Project Structure](#-project-structure)
- [🚀 Quick Start Guide](#-quick-start-guide)
  - [Prerequisites](#prerequisites)
  - [1. Clone Repository](#1-clone-repository)
  - [2. Configure Database](#2-configure-database)
  - [3. Run the Backend](#3-run-the-backend)
  - [4. Access the Application](#4-access-the-application)
- [🔑 Demo Credentials](#-demo-credentials)
- [🔌 API Endpoints](#-api-endpoints)
- [🐳 Docker & Cloud Deployment](#-docker--cloud-deployment)
- [🤝 Contributing](#-contributing)
- [📄 License](#-license)

---

## ✨ Features

### 👑 Admin Capabilities
- **User Management**: Add, view, edit, and remove Students, Teachers, and Admin accounts. Assign rolls, batches, and phone numbers.
- **Academic Setup**:
  - Create and manage **Batches** (e.g., Batch 2024, Batch 2025).
  - Configure **Courses** with fees tied to specific batches.
  - Create **Subjects** under courses and assign dedicated teachers.
- **Routine Builder**: Create and maintain class schedules (Day-wise, Period-wise, Room allocations).
- **Payment Auditing**: Monitor student fee payments, payment methods (bKash/Nagad/Card), and transaction verification IDs.
- **Institute Notice Board**: Post official announcements visible to all members.

### 👨‍🏫 Teacher Capabilities
- **Subject Dashboard**: Access all subjects assigned to the logged-in teacher.
- **Attendance Management**: Mark and update student attendance (Present, Absent, Late [0.5 credit]) for scheduled class sessions.
- **Dynamic Assessment & Grading**:
  - Configure exam criteria (Class Tests / CTs, Midterm, Final, Assignments).
  - Dynamic mark entry sheet with auto-calculating totals and persistent configurations (`MarkConfig`).
  - Update and revise exam scores in real time.
- **Class Schedules**: View scheduled routine slots and subject periods.
- **Communication**: Send targeted announcements and private messages to students and faculty.

### 🎓 Student Capabilities
- **Student Profile**: View personal academic profile, roll number, batch, and registered courses.
- **Course Enrollment & Fee Payment**:
  - Browse available courses for their batch.
  - Integrated checkout simulation supporting Mobile Banking (**bKash**, **Nagad**) and Debit/Credit Cards with transaction reference tracking.
- **Academic Scorecard**: Review subject-wise marks, examination scores, and grades.
- **Attendance Summary**: Monitor session-by-session attendance and calculated attendance percentages.
- **Class Routine**: Interactive timetable showing daily class timings, periods, and teachers.
- **Notice Board**: Stay informed with latest institute updates and batch notices.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| **Backend Framework** | [Spring Boot 3.2.5](https://spring.io/projects/spring-boot) |
| **Language & SDK** | Java 17 |
| **Security & Auth** | Spring Security 6.x, BCrypt Password Hashing, CORS Configuration |
| **Database & ORM** | Spring Data JPA, Hibernate, MySQL 8 / H2 in-memory |
| **Frontend** | Vanilla JavaScript (ES6+ SPA), Modern HTML5, Custom CSS3 Design |
| **Build & Tooling** | Apache Maven 3.9+ |
| **Deployment** | Docker (Multi-stage build), Render (`render.yaml`), Clever Cloud MySQL |

---

## 📂 Project Structure

```text
Education-Institute-Management-Sytem/
├── Dockerfile                         # Root multi-stage Docker build
├── render.yaml                        # Render Cloud deployment blueprint
├── run-backend.bat                    # One-click Windows startup script
├── index.html                         # Frontend Single Page Application
├── app.js                             # Frontend business logic & API client
├── style.css                          # Modern UI styling & themes
├── backend/                           # Spring Boot REST API
│   ├── Dockerfile                     # Backend-specific Dockerfile
│   ├── pom.xml                        # Maven dependencies & build config
│   └── src/
│       ├── main/
│       │   ├── java/com/smartcoaching/
│       │   │   ├── SmartCoachingApplication.java
│       │   │   ├── config/            # SecurityConfig, CORS
│       │   │   ├── controller/        # REST Controllers (Auth, User, Course, etc.)
│       │   │   ├── dto/               # Auth & Data Transfer Objects
│       │   │   ├── entity/            # JPA Entities (User, Batch, Attendance, Mark...)
│       │   │   ├── repository/        # Spring Data JPA Repositories
│       │   └── service/           # Business logic & DataSeedService
│       │   └── resources/
│       │       ├── application.properties # Server & DataSource configuration
│       │       └── static/            # Synced static assets for production
└── README.md                          # Project documentation
```

---

## 🚀 Quick Start Guide

### Prerequisites
- **Java Development Kit (JDK)**: Version 17 or higher (`java -version`)
- **Apache Maven**: Version 3.8+ (`mvn -version`)
- **Git**: Latest version installed

---

### 1. Clone Repository

```bash
git clone https://github.com/it22030/Education-Institute-Management-Sytem.git
cd Education-Institute-Management-Sytem
```

---

### 2. Configure Database

The project is pre-configured with a remote cloud MySQL database. If you wish to use a **local MySQL** or **in-memory H2 database**, update `backend/src/main/resources/application.properties`:

#### Option A: Local MySQL
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smart_coaching?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

#### Option B: In-Memory H2 (For Quick Offline Testing)
```properties
spring.datasource.url=jdbc:h2:mem:coachingdb;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

---

### 3. Run the Backend

#### Windows (Command Prompt / PowerShell):
You can use the provided batch script or run Maven directly:
```bash
# Using the shortcut script:
./run-backend.bat

# Or navigating to the backend folder:
cd backend
mvn spring-boot:run
```

#### Linux / macOS:
```bash
cd backend
mvn spring-boot:run
```

The Spring Boot backend will start on **`http://localhost:8080`**.  
On initial boot, default demo batches, users, courses, and subjects are automatically populated by `DataSeedService`.

---

### 4. Access the Application

Once the backend is running, open your web browser:
- **Direct Web Access**: Open **`http://localhost:8080/index.html`** (or `http://localhost:8080/`)
- Or simply open `index.html` locally in any modern browser.

---

## 🔑 Demo Credentials

The database automatically seeds test accounts upon first startup:

| Role | Email | Password | Permissions |
|:---:|:---:|:---:|:---|
| **Admin** | `admin@coaching.com` | `admin123` | Full control over users, courses, batches, routines, notices |
| **Teacher** | `teacher@coaching.com` | `teacher123` | Mark attendance, manage exam marks/grades, view schedule |
| **Student** | `student@coaching.com` | `student123` | Course enrollment, fee payment, check marks, view routine |

> 💡 *You can also click **Register** on the login page to create a new student or teacher account at any time.*

---

## 🔌 API Endpoints

| Module | Method | Endpoint | Description |
|---|---|---|---|
| **Auth** | `POST` | `/api/auth/login` | Authenticate user & retrieve profile |
| **Auth** | `POST` | `/api/auth/register` | Register new student or teacher |
| **Users** | `GET` | `/api/users` | List all users (Filter by role) |
| **Users** | `PUT` | `/api/users/{id}` | Update user details / batch / roll |
| **Users** | `POST` | `/api/users/change-password` | Change user password |
| **Batches** | `GET` / `POST` | `/api/batches` | Retrieve or create academic batches |
| **Courses** | `GET` / `POST` | `/api/courses` | List or create courses with fees |
| **Subjects** | `POST` | `/api/courses/{id}/subjects` | Add subject under course & assign teacher |
| **Enrollments** | `GET` / `POST` | `/api/enrollments` | Manage student course enrollments |
| **Payments** | `POST` | `/api/payments` | Record course fee payment transaction |
| **Attendance** | `POST` | `/api/attendance/mark` | Record daily attendance (Present/Late/Absent) |
| **Marks** | `POST` | `/api/marks/save-bulk` | Save exam marks for students |
| **Mark Config** | `GET` / `POST` | `/api/marks/config` | Manage exam criteria & weight configuration |
| **Routine** | `GET` / `POST` | `/api/routines` | Get or update class routine schedule |
| **Notices** | `GET` / `POST` | `/api/notices` | Publish and view institute notices |

---

## 🐳 Docker & Cloud Deployment

### Run with Docker

```bash
# Build the container image
docker build -t education-management .

# Run the container on port 8080
docker run -p 8080:8080 education-management
```

### Render Deployment
This repository includes a `render.yaml` blueprint for zero-config deployment on [Render](https://render.com/):
1. Connect your GitHub repository to Render.
2. Select **New Blueprint Instance**.
3. Render automatically picks up `render.yaml`, builds the multi-stage Docker container, and exposes the application.

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!
1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

Distributed under the **MIT License**.
