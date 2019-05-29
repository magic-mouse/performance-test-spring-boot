FROM maven:3.5-jdk-11 as BUILD

COPY src /usr/src/demo/src
COPY pom.xml /usr/src/demo/src
RUN mvn -f /usr/src/demo/src package -e

FROM openjdk:13-jdk-alpine
COPY --from=BUILD /usr/src/demo/src/target/*.jar /opt/demo.jar

#ENTRYPOINT ["java","-jar","/opt/demo.jar"]