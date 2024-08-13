#Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container at /app
COPY target/cartservice-0.0.1-SNAPSHOT.jar /app/application.jar

# Expose the port the application runs on
EXPOSE 8081


# Run jar file using java

ENTRYPOINT ["java", "-jar", "application.jar"]