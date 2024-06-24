# Delivery API for data analytics project

## Getting started
- **build image**: docker build -t my-spring-boot-app .
- **run container**: docker run -p 8080:8080 my-spring-boot-app
- **sanity check**: go to http://localhost:8080/swagger-ui.html and try out endpoints (in /deliveries endpoint request field *earliestDateTime* needs to be formatted to *yyyy-MM-dd HH:mm:ss.SSSSSS*)

