# student-class-assignment (sca)

Application to manage students and classes assignment

This application is developed using multi layer architecture pattern and has the next layers:

- Persistence API Layer (sca-ds): This layer contains the POJOs and DAOs. 
To persist the information this layer is integrated with Derby that is an Apache sub project relational in-memory database.
It uses Hibernate that is an Object/Relational Mapping framework with JPA provider and the use of HQL to develop queries.  
- Business Logic Layer (sca-core): In this layer is implemented the business logic of the application, it depends on sca-ds layer to use DAOs. 
- RESTful Web Service Interface (sca-api): In this layer is implemented a RESTful Web service, that can be accessed by an automated client or an application and offer a lot of functions implemented in core layer.  
- Web Interface (sca-web): This is is a web based application that uses the core layer functions.

All layers use many modules of spring framework to handle servlet,  implement beans, DAO tests and RESTful web service.


You can found the distributable wars in 'dist' folder.