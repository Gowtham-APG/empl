# Stage 1: Build using Maven
FROM maven:3.8.5-openjdk-17-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime with JRE
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=builder /app/target/EMS-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
