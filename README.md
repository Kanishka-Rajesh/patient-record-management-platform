<div align="center">

# Enterprise Patient Record Management Platform

### Full Stack Healthcare Management System

<p align="center">
<img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk">
<img src="https://img.shields.io/badge/Spring_Boot-3.4-success?style=for-the-badge&logo=springboot">
<img src="https://img.shields.io/badge/Spring_Security-JWT-green?style=for-the-badge">
<img src="https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql">
<img src="https://img.shields.io/badge/REST_API-Enterprise-red?style=for-the-badge">
<img src="https://img.shields.io/badge/HTML5-CSS3-JavaScript?style=for-the-badge">
</p>

A secure, scalable, enterprise-grade Patient Record Management Platform developed using Spring Boot, Spring Security, JWT Authentication, MySQL, RESTful APIs and a responsive frontend.

</div>

---

# Table of Contents

- Overview
- Features
- Architecture
- Technology Stack
- Security
- System Modules
- REST API
- Database Design
- Project Structure
- Installation
- Running the Application
- Future Enhancements
- Learning Outcomes
- Author

---

# Overview

The Enterprise Patient Record Management Platform is a full-stack healthcare management application designed to digitize patient information, appointment scheduling, prescription management, and clinical workflows.

The project follows modern backend development practices using Spring Boot and REST architecture while implementing secure authentication using JWT and Spring Security.

It aims to simulate a real-world hospital information system instead of a traditional CRUD application.

---

# Features

## Authentication & Authorization

- Secure JWT Authentication
- User Login
- User Registration
- Password Encryption using BCrypt
- Stateless Authentication
- Protected REST APIs
- Spring Security Integration
- Role-based backend structure (extendable)

---

## Patient Management

- Register New Patients
- View Patient Details
- Update Patient Information
- Delete Patient Records
- Search Patients
- Patient History Management

---

## Appointment Management

- Book Appointments
- Update Appointments
- Cancel Appointments
- View Scheduled Appointments
- Appointment Tracking

---

## Prescription Management

- Create Prescriptions
- Update Prescriptions
- View Patient Prescriptions
- Maintain Medication History

---

## Medication Management

- Add Medications
- Update Medication Details
- Delete Medications
- Medication Tracking

---

## Dashboard

- Total Patients
- Total Appointments
- Total Prescriptions
- Summary Statistics
- Real-time Dashboard APIs

---

## Backend

- RESTful API Design
- Layered Architecture
- DTO Validation
- Exception Handling
- Service Layer
- Repository Layer
- Dependency Injection
- Spring Data JPA
- Hibernate ORM

---

## Frontend

- Responsive User Interface
- HTML5
- CSS3
- Vanilla JavaScript
- Fetch API Integration
- Dynamic API Communication
- Clean User Experience

---

# Architecture

```
                Client Browser
                      │
                      ▼
           HTML • CSS • JavaScript
                      │
                REST API Calls
                      │
                      ▼
             Spring Boot Backend
                      │
        Spring Security + JWT
                      │
      Service Layer (Business Logic)
                      │
       Spring Data JPA + Hibernate
                      │
                      ▼
                 MySQL Database
```

---

# Technology Stack

| Category | Technologies |
|----------|--------------|
| Language | Java 21 |
| Backend | Spring Boot |
| Security | Spring Security |
| Authentication | JWT |
| ORM | Hibernate |
| Persistence | Spring Data JPA |
| Database | MySQL |
| Frontend | HTML5, CSS3, JavaScript |
| API | REST |
| Build Tool | Maven |
| Version Control | Git |
| Repository | GitHub |
| Deployment | Railway |

---

# Security

The application implements enterprise-level authentication using Spring Security and JWT.

Security features include:

- JWT Token Authentication
- BCrypt Password Encryption
- Stateless Sessions
- Protected Endpoints
- Authentication Filters
- Secure Password Storage
- Unauthorized Request Handling
- Secure API Access

---

# System Modules

## Authentication Module

- User Registration
- User Login
- JWT Generation
- JWT Validation

---

## Patient Module

- Add Patient
- Update Patient
- Delete Patient
- Search Patient
- View Patient

---

## Appointment Module

- Schedule Appointment
- Update Appointment
- Cancel Appointment
- Appointment History

---

## Medication Module

- Add Medication
- Update Medication
- Delete Medication
- Medication Records

---

## Prescription Module

- Create Prescription
- View Prescription
- Update Prescription

---

## Dashboard Module

- Patient Statistics
- Appointment Statistics
- Prescription Statistics
- Dashboard Summary

---

# REST API

## Authentication

```
POST /api/auth/register
POST /api/auth/login
```

---

## Patients

```
GET    /api/patients
GET    /api/patients/{id}
POST   /api/patients
PUT    /api/patients/{id}
DELETE /api/patients/{id}
```

---

## Appointments

```
GET    /api/appointments
POST   /api/appointments
PUT    /api/appointments/{id}
DELETE /api/appointments/{id}
```

---

## Medications

```
GET    /api/medications
POST   /api/medications
PUT    /api/medications/{id}
DELETE /api/medications/{id}
```

---

## Prescriptions

```
GET    /api/prescriptions
POST   /api/prescriptions
PUT    /api/prescriptions/{id}
DELETE /api/prescriptions/{id}
```

---

## Dashboard

```
GET /api/dashboard
```

---

# Database Design

Main database entities:

- Users
- Patients
- Appointments
- Prescriptions
- Medications

Relationships are managed using Spring Data JPA and Hibernate.

---

# Project Structure

```
patient-record-management/

├── frontend/
│   ├── index.html
│   ├── css/
│   ├── js/
│   └── assets/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   ├── dto/
│   ├── security/
│   ├── validation/
│   ├── util/
│   └── config/
│
├── pom.xml
├── application.properties
└── README.md
```

---

# Installation

Clone the repository

```bash
git clone https://github.com/Kanishka-Rajesh/patient-record-management-platform.git
```

Navigate to the project

```bash
cd patient-record-management-platform
```

Build the project

```bash
mvn clean install
```

Run the application

```bash
mvn spring-boot:run
```

---

# Running the Application

Backend

```
http://localhost:8080
```

Frontend

Open

```
frontend/index.html
```

or serve it using any local web server.

---

# Future Enhancements

- Doctor Management
- Nurse Management
- Billing System
- Laboratory Module
- Medical Reports Upload
- Email Notifications
- SMS Notifications
- PDF Prescription Generation
- Inventory Management
- Audit Logs
- Role Based Access Control
- Admin Dashboard
- Analytics Dashboard
- Docker Deployment
- Kubernetes Support
- CI/CD Pipeline
- Cloud Storage Integration
- File Uploads
- Multi Hospital Support

---

# Learning Outcomes

This project demonstrates practical experience in:

- Spring Boot Development
- Spring Security
- JWT Authentication
- REST API Development
- Hibernate ORM
- Spring Data JPA
- MySQL Database Design
- Layered Architecture
- Backend Development
- Full Stack Development
- Authentication & Authorization
- API Integration
- Enterprise Software Design
- Git & GitHub Workflow
- Cloud Deployment using Railway

---

# Key Highlights

- Enterprise-inspired healthcare management platform
- Secure JWT-based authentication
- Layered backend architecture
- RESTful API implementation
- Spring Security integration
- Hibernate & JPA persistence
- Responsive frontend
- MySQL relational database
- Railway cloud deployment
- Modular and scalable design
- Clean separation of concerns
- Resume-ready full-stack project

---

# Author

**Kanishka Rajesh**

Information Technology Undergraduate  
SSN College of Engineering

GitHub

https://github.com/Kanishka-Rajesh

LinkedIn

(Add your LinkedIn profile here)

---

## License

This project is intended for educational purposes, portfolio demonstration, and learning full-stack enterprise application development.
