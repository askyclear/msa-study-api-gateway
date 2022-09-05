FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY target/apigateway-1.0.jar Apigateway.jar
ENTRYPOINT ["java", "-jar", "Apigateway.jar"]