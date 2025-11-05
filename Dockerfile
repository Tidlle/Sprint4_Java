# Etapa de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -DskipTests package

# Etapa de execução
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/quarkus-app /app
ENV QUARKUS_HTTP_PORT=${PORT}
EXPOSE 8080
CMD ["java", "-jar", "/app/quarkus-run.jar"]
