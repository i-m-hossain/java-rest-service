## Hibernate:
Hibernate is the implementation of jpa. (Jakarta Persistence API)

## Spring JPA:
We can directly talk to a database using the model attributes and Entity manager methods. Here we don't need to instruct explicitly to use sql queries. The model attributes directly map into database columns.
## Spring JDBC
Spring JDBC allows us to run raw sql queries in our Spring Boot application

## H2 console
- To Access H2 database: [h2-console-link](http://localhost:8080/h2-console)
- To make the connection string static ``spring.datasource.url=jdbc:h2:mem:testdb`` property added in ``application.properties``

## Run a command at startup:
To run any command at the application startup, ``CommandLineRunner`` interface needs to be implemented.   