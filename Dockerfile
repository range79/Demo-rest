FROM openjdk:17 
COPY build/libs/demo1-1.1.0.jar /app/demo.jar
WORKDIR /app/
CMD ["java", "-jar", "demo.jar"]
