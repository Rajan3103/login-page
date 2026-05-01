# Full-Stack Login Page Application

A modern, full-stack Login and Signup application featuring a sleek React frontend and a robust Java Spring Boot REST API backend. The project demonstrates user authentication, database persistence, and secure cross-origin communication between a detached frontend and backend.

## Tech Stack

### Frontend
- **React 18**
- **TypeScript**
- **Vite** (Build Tool & Dev Server)
- **React Router v6** (Client-side routing)
- **Vanilla CSS** (Premium Glassmorphism Design & Micro-animations)

### Backend
- **Java 23**
- **Spring Boot 3**
- **Spring Security** (Stateless REST API Security & CORS configuration)
- **Spring Data JPA / Hibernate**
- **MySQL Database**

## Project Features
- **User Registration (Signup):** Allows new users to create an account. Checks for existing usernames to prevent duplicates.
- **User Authentication (Login):** Authenticates users against the database using securely stored credentials.
- **Modern UI/UX:** Responsive, dark-mode glassmorphism interface with smooth hover effects and validation feedback.
- **Vite Proxy:** Uses Vite's built-in proxy to elegantly bypass CORS issues during local development.

---

## How to Run the Project Locally

### Prerequisites
1. **Java Development Kit (JDK):** Version 17 or higher (Project uses Java 23).
2. **Node.js & npm:** Required to run the React frontend.
3. **MySQL Database:** Running locally on port 3306.

### 1. Database Setup
Ensure your local MySQL server is running. Create a database named `login1`:
```sql
CREATE DATABASE login1;
```
*(The backend connects using username: `root` and password: `root123`. You can modify these in `src/main/resources/application.properties` if needed).*

### 2. Start the Spring Boot Backend
The backend runs on port `8080`.
Open a terminal in the root directory of the project and run the Maven wrapper:

**Windows:**
```powershell
.\mvnw.cmd spring-boot:run
```
**Mac/Linux:**
```bash
./mvnw spring-boot:run
```
*(Note: Hibernate `ddl-auto` is set to `update`, so the `users` table will automatically be generated in your database upon startup).*

### 3. Start the React Frontend
The frontend runs on port `5173`.
Open a **new, separate terminal**, navigate into the `frontend` directory, install dependencies, and start the Vite dev server:

```bash
cd frontend
npm install
npm run dev
```

### 4. Access the Application
Once both servers are running, open your web browser and navigate to:
**http://localhost:5173/login**
