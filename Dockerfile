FROM openjdk
MAINTAINER Amit Mujawar <amit.mujawar@mindstix.com>
ADD target/spring-boot-rest-example-0.5.0.war spring-boot-api.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-api.jar"]
EXPOSE 8090
