FROM maven:3.9.4-eclipse-temurin-21 AS build
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /app/target/educourses-0.0.1.jar /app/educourses.jar
ENTRYPOINT ["java", "-jar", "/app/educourses.jar"]
