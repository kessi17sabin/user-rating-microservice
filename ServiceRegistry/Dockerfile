FROM openjdk:17-alpine
MAINTAINER sabin.khatri
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} service-registry.jar
ENTRYPOINT ["java", "-jar", "/service-registry.jar"]
EXPOSE 8761