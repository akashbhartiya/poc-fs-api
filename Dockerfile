FROM openjdk:8-jdk-alpine
MAINTAINER Akash_Bhartiya
COPY target/poc-fs-api-0.0.1-SNAPSHOT.jar mypoc-app-1.0.0.jar
ENTRYPOINT ["java","-jar","/mypoc-app-1.0.0.jar"]