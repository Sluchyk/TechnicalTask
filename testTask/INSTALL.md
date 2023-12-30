Getting Started
Prerequisites
Java 11
Maven
MySQL
Database Configuration
Create a MySQL database for the application:

sql
Copy code
CREATE DATABASE job_scraper;

Update the application.properties file with your MySQL database configuration:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/job_scraper
spring.datasource.username=your-username
spring.datasource.password=your-password
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/your-username/job-scraper.git
Build the project:

bash
Copy code
cd job-scraper
mvn clean install
Run the application:

bash
Copy code
java -jar target/job-scraper-1.0.jar
Usage
Open your browser and navigate to http://localhost:8080.

Input desired work functions or job categories.

View the scraped job listings presented in a user-friendly format.

Use filter and sort options to refine the results based on preferences.