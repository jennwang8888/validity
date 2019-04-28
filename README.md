gs-spring-boot

Requirements

JDK 1.8
Maven 3

update file.path with location of the parses csv file in file src\main\resources\application.properties

Build

mvn clean install

Run

mvn spring-boot:run

Test

startup test http://localhost:8080 should get back "Greetings from Spring Boot!"

Run URL

http://http://localhost:8080/get2/{fileName} the filename without extension. ex http://localhost:8080/get2/advanced
