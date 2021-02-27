FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} online_shop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/online_shop-0.0.1-SNAPSHOT.jar"]