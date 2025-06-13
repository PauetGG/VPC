FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/VpcApi-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8