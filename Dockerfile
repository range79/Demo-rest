FROM openjdk:17 
COPY build/libs/demo1-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
CMD ["java", "-jar", "demo1-0.0.1-SNAPSHOT.jar"]
