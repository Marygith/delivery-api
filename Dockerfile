# Use the official Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download the project dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the entire project and build it
COPY src ./src
RUN mvn clean package -DskipTests

# Use the official OpenJDK image for the runtime environment
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Copy the JSON files
COPY src/main/resources/files/deliverymen.json /app/files/deliverymen.json
COPY src/main/resources/files/deliveries.json /app/files/deliveries.json

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]

# Expose the port your Spring Boot application runs on
EXPOSE 8080