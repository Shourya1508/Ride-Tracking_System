FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar app.jar
COPY src/main/resources/certificates /app/certs

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar", \
"--server.ssl.key-store=/app/certs/driver-service.jks", \
"--server.ssl.key-store-password=changeit", \
"--server.ssl.key-store-type=JKS", \
"--server.ssl.enabled=true", \
"--server.port=8081", \
"--server.ssl.trust-store=/app/certs/driver-service-truststore.jks", \
"--server.ssl.trust-store-password=changeit"]