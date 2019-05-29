FROM maven:3.5-jdk-8 as BUILD

COPY src /usr/src/demo/src
COPY pom.xml /usr/src/demo
RUN mvn -f /usr/src/demo/pom.xml clean package -DskipTests


FROM openjdk:8-jdk-alpine
COPY --from=BUILD /usr/src/demo/target/*.jar /opt/app.jar

ENTRYPOINT ["java","-jar","/opt/app.jar"]