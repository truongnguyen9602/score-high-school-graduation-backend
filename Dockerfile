FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline
COPY src /app/src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/score-high-school-graduation-be-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-jar", "score-high-school-graduation-be-0.0.1-SNAPSHOT.jar"]
