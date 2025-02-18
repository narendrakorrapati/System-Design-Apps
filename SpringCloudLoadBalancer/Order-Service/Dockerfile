# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set environment variables
ENV ORDER_SERVICE_PORT=8081

# Copy JAR file from target folder
COPY target/Order-Service-*.jar app.jar

# Expose service port
EXPOSE ${ORDER_SERVICE_PORT}

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]