FROM openjdk:24-ea-21-jdk-slim AS build

COPY src /app/src
COPY pom.xml /app
COPY mvnw /app
COPY mvnw.cmd /app

WORKDIR /app

RUN mvn clean install

COPY --from=build /app/target/demo-docker0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]