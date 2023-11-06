# Use a base image with Java 17 installed
FROM openjdk:17-jdk-slim AS build

RUN apt-get update && apt-get install -y maven

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a base image with Java 17 installed
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build finunsizeapi.jar .

# Copy the .env file
COPY .env .

# Expose the port that the application listens on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "finunsizeapi.jar"]
