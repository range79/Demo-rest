FROM gradle:7.6-jdk17
COPY . /app
WORKDIR /app/
RUN ./gradlew build -x test
CMD ["java", "-jar", "build/libs/demo1-1.2.0.jar"]