# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set environment variables
ENV USER_SERVICE_PORT=8082

# Copy JAR file from target folder
COPY target/User-Service-*.jar app.jar

# Expose service port
EXPOSE ${USER_SERVICE_PORT}

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]