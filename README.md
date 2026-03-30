# Full-Stack Blog Platform

A full-stack blogging application designed for a seamless writing and reading experience. 

It is built with a Java Spring Boot backend and a React + Vite frontend, utilizing a PostgreSQL database for reliable data storage.

## ✨ Features

- **Multi-user Authentication**: Full user registration and secure login authenticated via JSON Web Tokens (JWT).
- **Rich Text Editor**: Write beautiful content easily using the integrated **Tiptap Editor** with live markdown-like formatting (Headers, Lists, Bold, Italic).
- **Draft & Publish Workflow**: Save works-in-progress as drafts before officially publishing them to your readers.
- **Categorization & Tagging**: Organize posts by granular categories and multiple tags for easy discovery.
- **Intelligent Read-Time Analysis**: Automatically calculates estimated reading times for all published posts.
- **Modern UI Edge**: Built with Tailwind CSS and NextUI (HeroUI) components for a sleek, responsive, and glassmorphism-inspired aesthetic across mobile and desktop.
- **Serverless-Ready Deployment**: Includes pre-configured Dockerfiles and environment-variable workflows out-of-the-box for drop-in deployments on Render and Vercel.

## 🛠️ Technology Stack

### Backend
- **Java 21**: The latest LTS enterprise runtime.
- **Spring Boot 3.5**: Rapid application development framework providing RESTful APIs.
- **Spring Security**: Stateless REST API protection.
- **Spring Data JPA & Hibernate**: Elegant ORM database management.
- **PostgreSQL**: Production-grade relational database.
- **JWT (jjwt)**: Stateless, decentralized session management.
- **MapStruct & Lombok**: Automated DTO mapping and boilerplate reduction.

### Frontend
- **React 18 & Vite**: Lightning-fast hot module replacement and framework base.
- **Axios & React Router Dom**: Client-side API fetching and navigation routing.
- **NextUI & Tailwind CSS**: Phenomenal, highly customizable UI component library and styling utility.
- **Tiptap**: Headless, extensible rich text editor.
- **DOMPurify**: Sanitization of rich-text HTML against XSS vulnerabilities.

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed on your local machine:
- **Java Development Kit (JDK) 21**
- **Node.js** (v18 or higher)
- **PostgreSQL Server** (or a cloud instance via Supabase/Neon)
- **Maven** (optional, an embedded wrapper `./mvnw` is included)

### 1. Database Configuration

You need a running PostgreSQL database. Create a new database or schema for the application.
Open `src/main/resources/application.properties` and update the environment variable fallbacks or configure them in your runtime environment:

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/your-db-name}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:postgres}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:yourpassword}
jwt.secret=${JWT_SECRET:your-highly-secure-256-bit-secret-key-that-is-very-long}
```

*Note: Since `spring.jpa.hibernate.ddl-auto=update` is configured, Spring Boot will automatically spin up and map all necessary database tables on its first run.*

### 2. Running the Backend

Open a terminal in the root directory and run the Maven wrapper to build and start the Spring Boot API:

```bash
# Download dependencies and build the jar
./mvnw clean package -DskipTests

# Run the application (Default port 8080)
java -jar target/blog-0.0.1-SNAPSHOT.jar
```
*(Alternatively, simply run the application directly from your IDE of choice like IntelliJ or VS Code)*

### 3. Running the Frontend

Open a new, separate terminal and navigate to the frontend directory:

```bash
cd frontend-blog-application

# Install dependencies
npm install

# Start the Vite development server
npm run dev
```

Your React application will likely be exposed at `http://localhost:5173`. 
The Vite API proxy is natively configured to reroute any request beginning with `/api/v1` accurately over to the Java backend at `http://localhost:8080`.

## ☁️ Deployment

**Backend (Render/Railway/Fly.io):**
- A multi-stage `Dockerfile` is included in the remote root.
- Simply establish your PaaS provider to link against this GitHub repository using **Docker** as its designated Environment.
- Provide the database connection configurations directly as secure Environment Variables.

**Frontend (Vercel/Netlify):**
- Import the repository and set the **Root Directory** to `frontend-blog-application`.
- Assign the Framework preset to Vite.
- Set a **Production Environment Variable** defining the API domain:
  `VITE_API_BASE_URL` = `https://your-live-backend-api.com/api/v1`

---
> You can easily generate a random secure string for your JWT secret during configuration using sites like [jwtsecrets.com](https://jwtsecrets.com/).
