FROM openjdk:17-alpine
MAINTAINER sabin.khatri
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} rating-service.jar
ENTRYPOINT ["java", "-jar", "/rating-service.jar"]
EXPOSE 8083