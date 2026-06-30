# Car Rental Marketplace System

A Java-based peer-to-peer car rental marketplace application built using Java Swing, JDBC, and PostgreSQL.

This project allows users to:
- Register and login
- List their own cars for rent
- Search available cars by location
- Rent cars from other users
- Return rented cars
- View rental history
- Manage listed vehicles

The application follows a layered architecture using DAO, Session Management, Swing UI Panels, and PostgreSQL database integration.

---

# Features

## Authentication System
- User Registration
- User Login
- Forgot Username
- Forgot Password
- Session Management
- Logout

---

## Marketplace Features
- Give Car on Rent
- Rent Available Cars
- Location-Based Search
- Car Availability Management
- Return Car System

---

## User Dashboard
- Home Dashboard
- My Rentals
- My Listed Cars
- Profile Section
- About Section
- Refresh Dashboard

---

## Database Features
- JDBC Connectivity
- PostgreSQL Integration
- DAO Layer Architecture
- Foreign Key Relationships
- Dynamic Data Fetching

---

# Technologies Used

- Java
- Java Swing
- JDBC
- PostgreSQL
- IntelliJ IDEA
- Git & GitHub

---

# Project Structure

src/
│
├── DAO_Layer
├── Database
├── Model_Layer
├── Session
├── UI_Layer
└── Test

---

# Database Tables

## customer
Stores:
- Customer ID
- Name
- Username
- Email
- Password
- Phone

---

## car
Stores:
- Car Details
- Category
- Price Per Day
- Location
- Availability
- Owner ID

---

## rental
Stores:
- Rental Information
- Customer ID
- Car ID
- Rental Days
- Total Price
- Rental Date

---

# Application Workflow

User Login/Register
↓
Dashboard
↓
List Car OR Rent Car
↓
Rental Stored in Database
↓
Car Availability Updated
↓
Return Car
↓
Availability Restored

---

# How To Run

## 1. Clone Repository

```bash
git clone https://github.com/yourusername/car-rental-marketplace.git
```

---

## 2. Open Project in IntelliJ IDEA

Import project as Java project.

---

## 3. Configure PostgreSQL

Create database and required tables:
- customer
- car
- rental

Update database credentials in:

```text
DBConnection.java
```

---

## 4. Add PostgreSQL JDBC Driver

Add PostgreSQL JDBC `.jar` file to project libraries.

---

## 5. Run Project

Run:

```text
Main.java
```

or launch:

```text
WelcomeUI.java
```

---

# Future Improvements

- Car Images
- Admin Dashboard
- Ratings & Reviews
- Payment Integration
- Email Verification
- Earnings Dashboard
- Edit Profile
- Notifications

---

# Developer

Salem Saudagar

Java Developer 

---
