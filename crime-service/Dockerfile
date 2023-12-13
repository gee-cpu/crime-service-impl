
FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} crimeservice.jar

ENTRYPOINT ["java", "-jar", "/crimeservice.jar"]