Easy Notes

This is an extension of a blog post I ran across that demonstrates how easy one can make a service in Spring Boot.  The page is https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

What I added is the ability to HTTP POST a JSON document which contains a compound JSON file and have the entire contents of the JSON document stored into its respective tables in the database.

The base setup utilizes an embedded H2 database, but its been tested with PostgreSQL and the application.properties file contains the setup for a local PostgreSQL database.

# Running    

mvn clean install -DskipTests=true  spring-boot:run

## Sample JSON

{"title": "Note number 1", "content": "Spring Boot and Docker", "user": {"name":"Mark"}, "permissions":{"permission":"ReadOnly"} }