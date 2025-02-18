# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set environment variables
ENV EUREKA_PORT=8761

# Copy JAR file from target folder
COPY target/Eureka-Server-*.jar app.jar

# Expose Eureka server port
EXPOSE ${EUREKA_PORT}

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]