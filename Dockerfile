FROM openjdk:17
COPY build/libs/demo1-0.0.1-SNAPSHOT.jar /app/src/app.jar
WORKDIR /app/src
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]