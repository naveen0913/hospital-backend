# janitri-backend

**Overview**
This is a Java Spring Boot project built using Spring Boot 3.1.x (Java 21) and connected to a MySQL database. The project serves as a starting point for building RESTful APIs or any backend services.

**Features**
Built using Spring Boot 3.1.x.
MySQL integration for data persistence.

**Prerequisites**
Ensure you have the following installed before running the application:

1) Java 21 (JDK 21+)
2) Maven (version 3.6 or higher)
3) MySQL (version 8.0 or higher)

**Setup Instructions**

**Step 1: Clone the Repository**
git clone <repository-url>
cd <repository-name>

**Step 2: Configure MySQL Database**
1) Start your MySQL server in local.
2) CREATE DATABASE janitri;
3) Update the src/main/resources/application.properties file with your MySQL details:

   spring.datasource.url=jdbc:mysql://localhost:3306/janitri
   spring.datasource.username=<your-mysql-username>
   spring.datasource.password=<your-mysql-password>
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

**Step 3: Build the Project**
1) build the project using **ctrl+F9**

**Step 4: Run the Application**
1) Open the terminal run this command => ./mvnw spring-boot:run 

**Step-5: Test the API using postman tool**


