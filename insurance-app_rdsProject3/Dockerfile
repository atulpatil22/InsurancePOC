FROM maven:3.8.4-openjdk-17
WORKDIR /app
COPY /target/insurance-app-0.0.1-SNAPSHOT-aws.jar ./app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]

