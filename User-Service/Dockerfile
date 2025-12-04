FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar app.jar
COPY src/main/resources/certificates /app/certs

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar", \
"--server.ssl.key-store=/app/certs/user-service.jks", \
"--server.ssl.key-store-password=changeit", \
"--server.ssl.key-store-type=JKS", \
"--server.ssl.enabled=true", \
"--server.port=8080", \
"--server.ssl.trust-store=/app/certs/user-service-truststore.jks", \
"--server.ssl.trust-store-password=changeit"]
