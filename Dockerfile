# base image on openjdk version 8
FROM openjdk:8-jdk-alpine
ARG APP_DIR
ARG APP_WAR
RUN echo "$APP_DIR $APP_WAR"
# copy spring boot war
COPY $APP_DIR/$APP_WAR /usr/src/app/spring-boot-app.war
WORKDIR /usr/src/app
CMD ["java","-jar","-Dspring.profiles.active=test","spring-boot-app.war"]
