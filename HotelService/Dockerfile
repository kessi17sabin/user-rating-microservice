FROM openjdk:17-alpine
MAINTAINER sabin.khatri
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hotel-service.jar
ENTRYPOINT ["java", "-jar", "/hotel-service.jar"]
EXPOSE 8082