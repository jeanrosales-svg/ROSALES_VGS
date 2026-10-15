# Veterinary and Grooming Appointment System

Layered Java console app connected to an SQLite database (Maven).

## Requirements
- JDK 17 or higher
- Maven 3.8+

## Run
```
mvn compile exec:java
```
The `vetgrooming.db` file is created automatically on first run.

## Structure
```
src/main/java/com/vetgrooming
├── Main.java                  App entry point
├── dao/
│   ├── DatabaseConnection.java  SQLite connection + users table setup
│   └── UserDao.java             SQL queries (PreparedStatement)
├── model/
│   └── User.java                Java record
└── ui/
    ├── MainMenu.java            Register / Login / Exit
    └── UserMenu.java            Logged-in menu + Logout
```

## users table
| column   | type    | notes                          |
|----------|---------|--------------------------------|
| id       | INTEGER | primary key, auto-increment    |
| username | TEXT    | unique                         |
| password | TEXT    | salted SHA-256 hash            |
| roles    | TEXT    | TEACHER or STUDENT             |
| status   | TEXT    | defaults to PENDING            |
