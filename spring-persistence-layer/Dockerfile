# Use a Maven image to build the application
FROM maven:3.8.6-openjdk-17-slim AS build
WORKDIR /app

# Copy the pom.xml and the source files
COPY pom.xml .
COPY src ./src

# Package the application, skipping tests
RUN mvn clean package -DskipTests

# Use a smaller image to run the application
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Set arguments for the JAR naming
ARG ARTIFACT_NAME=spring-persistence-layer
ARG VERSION=0.0.1-SNAPSHOT

# Copy the JAR file from the build stage
COPY --from=build /app/target/${ARTIFACT_NAME}-${VERSION}.jar app.jar

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "/app.jar"]