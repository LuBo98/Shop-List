# Use Maven to build the application
FROM maven:3.9-amazoncorretto-17-alpine AS build
WORKDIR /app

# Copy pom.xml and source files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package

# Use OpenJDK to run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the application port
EXPOSE 9011

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]