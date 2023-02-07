FROM openjdk:8
ADD target/pariuri-docker.jar pariuri-docker.jar
ENTRYPOINT ["java", "-jar", "/pariuri-docker.jar"]