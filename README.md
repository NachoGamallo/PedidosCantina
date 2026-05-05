# PedidosCantina - IES Mutxamel Management System

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-6DB33F?style=flat&logo=springboot&logoColor=white)
![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=flat&logo=openjdk&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-latest-336791?style=flat&logo=postgresql&logoColor=white)
![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-3.x-38B2AC?style=flat&logo=tailwind-css&logoColor=white)

**PedidosCantina** is a professional management solution developed for the **IES Mutxamel** school canteen. The application provides an end-to-end workflow for tracking student information, managing product inventory, and processing food orders with real-time stock validation.

---

## Key Features

*   **Student Directory Management**: Access a comprehensive list of students including their names, courses, and unique contact numbers.
*   **Dynamic Inventory Control**: View real-time product status, including pricing and stock levels (Active vs. Out of Stock).
*   **Smart Order Registration**: 
    *   **Price Calculation**: Real-time estimation of order totals before saving.
    *   **Stock Validation**: Prevents orders if the requested quantity exceeds available inventory.
    *   **Transactional Updates**: Automatically deducts stock upon successful order placement.
*   **Order Fulfillment Workflow**: Dedicated dashboard for pending orders allowing staff to mark items as "delivered" to update system status.
*   **Personalized Histories**: View the complete order history for specific students, including total orders and individual order status.

---

## Technology Stack

### **Backend**
*   **Framework**: Spring Boot 4.0.3.
*   **Data Persistence**: Spring Data JPA with Hibernate.
*   **Database**: PostgreSQL.
*   **Utilities**: Project Lombok for clean entity and DTO management.

### **Frontend**
*   **Template Engine**: Thymeleaf.
*   **Styling**: Tailwind CSS for a modern, responsive user interface.
*   **Typography**: Inter via Google Fonts.

---

## Project Structure

The project follows a standard Maven architecture and Spring MVC design pattern:

```text
nachogamallo-pedidoscantina/
└── cantina/
    ├── src/main/java/org/ejercicio/cantina/
    │   ├── controller/    # HTTP Route Mapping (CantinaController)
    │   ├── entity/        # Database Models (Alumn, Order, Product)
    │   ├── repository/    # JPA Interfaces
    │   └── service/       # Business Logic & Transactions
    └── src/main/resources/
        ├── templates/     # Thymeleaf HTML Views
        └── import.sql     # Initial Database Seeding

```

## ⚙️ Configuration & Installation
**1. Database Setup**
Ensure you have a PostgreSQL instance running. By default, the application expects the following configuration in application.properties:

DB Name: gestion_cantina

Username/Password: postgres / postgres
URL: jdbc:postgresql://localhost:5432/gestion_cantina

**2. Running the Application**
Navigate to the cantina/ folder and use the provided Maven Wrapper:

*Windows:*

DOS
mvnw.cmd spring-boot:run

*Unix/macOS:*

Bash
./mvnw spring-boot:run
The application will be available at http://localhost:8080.

## Initial Data Seeding
Upon the first run, the system automatically executes import.sql to populate your environment with:

Initial Students: Profiles for Juan Pérez, María López, and Carlos Ruiz.

Product Catalog: Includes items like "Bocadillo de Jamón", "Zumo de Naranja", and out-of-stock items for validation testing.

## 📝 License
This project was developed for academic purposes at IES Mutxamel.
