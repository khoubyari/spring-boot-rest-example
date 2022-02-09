# Build container
FROM maven:3.5-jdk-8 as BUILD
WORKDIR /usr/src/myapp 
COPY src /usr/src/myapp/src
COPY pom.xml /usr/src/myapp
# building with  unit tests
RUN mvn clean package

# Application container
FROM openjdk:8-jre-slim-buster
WORKDIR /
EXPOSE 8091
EXPOSE 8090
COPY --from=BUILD /usr/src/myapp/target/spring-boot-rest-example-0.5.0.war .
CMD  ["java", "-jar", "-Dspring.profiles.active=test", "spring-boot-rest-example-0.5.0.war"]

