FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/AllocationService-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080