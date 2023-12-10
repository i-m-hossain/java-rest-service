## H2 console
- To Access H2 database: [h2-console-link](http://localhost:8080/h2-console)
- To make the connection string static ``spring.datasource.url=jdbc:h2:mem:testdb`` property added in ``application.properties``

## Run a command at startup:
To run any command at the application startup, ``CommandLineRunner`` interface needs to be implemented.   