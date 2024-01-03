Getting Started
Prerequisites
Java 17
Maven
MySQL
MySQL Workbench or any equivalent tool for managing MySQL databases
Docker

Database Configuration
Create a MySQL database for the application:

sql
Copy code
CREATE DATABASE IF NOT EXISTS your_database_name;
DROP TABLE IF EXISTS job_entity;
CREATE TABLE IF NOT EXISTS job_entity (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
job_page_url VARCHAR(255),
position_name VARCHAR(255),
url_to_organization VARCHAR(255),
logo_url VARCHAR(255),
organization_title VARCHAR(255),
labor_function VARCHAR(255),
address VARCHAR(255),
posted_date BIGINT,
description LONGTEXT,
tag_name VARCHAR(255)
);
ALTER TABLE job_entity CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE job_entity MODIFY COLUMN description longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


Update the application.properties file with your MySQL database configuration:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/scrapjob
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.connection.characterEncoding=utf8mb4
spring.jpa.properties.hibernate.connection.useUnicode=true
spring.jpa.hibernate.ddl-auto=update


run docker-compose file
docker-compose.yml

properties for docker
spring.datasource.url=jdbc:mysql://mysqldb:3306/scrabjob
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.connection.characterEncoding=utf8mb4
spring.jpa.properties.hibernate.connection.useUnicode=true
spring.jpa.hibernate.ddl-auto=update


Installation
Clone the repository:

bash
Copy code
git clone https://github.com/Sluchyk/TechnicalTask.git
Build the project:

bash
Copy code
cd TechnicalTask
mvn clean install
Run the application:

bash
Copy code
java -jar testTask-0.0.1-SNAPSHOT.jar
Usage
Open your browser and navigate to http://localhost:8080/job.

Input desired work functions or job categories.
