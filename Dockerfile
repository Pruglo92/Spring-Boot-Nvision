FROM openjdk:17-jdk
VOLUME /tmp
ARG JAR_FILE=target/Spring-Boot-Nvision-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Spring-Boot-Nvision-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Spring-Boot-Nvision-0.0.1-SNAPSHOT.jar"]