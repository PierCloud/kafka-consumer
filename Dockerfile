FROM openjdk:11
ADD target/demo-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT["java","-jar", "springboot-docker-demo.jar"]