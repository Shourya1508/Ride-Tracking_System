FROM eclipse-temurin:17-jdk

# STEP 2: Set working directory
WORKDIR /app

# STEP 3: Copy built jar file
COPY target/Notification-Service-*.jar app.jar

# STEP 4: Expose the port (same as application.properties)
EXPOSE 8084

# STEP 5: Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]