FROM openjdk:22-jdk AS build
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:22-jdk-slim
COPY --from=build /app/target/chat-app-0.0.1-SNAPSHOT demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]