FROM openjdk:17-alpine
MAINTAINER sabin.khatri
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} config-server.jar
ENTRYPOINT ["java", "-jar", "/config-server.jar"]
EXPOSE 8085