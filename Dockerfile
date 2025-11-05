# Build (JDK 17 + Maven)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# logs mais verbosos ajudam a ver o erro real no Render
RUN mvn -DskipTests -e -X -Dhttp.keepAlive=false -Dmaven.wagon.http.pool=false package

# Runtime (JRE 17)
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/quarkus-app /app
ENV QUARKUS_HTTP_PORT=${PORT}
EXPOSE 8080
CMD ["java", "-jar", "/app/quarkus-run.jar"]
