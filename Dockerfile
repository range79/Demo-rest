FROM openjdk:17
COPY . /app
WORKDIR /app/
RUN ./gradlew build --no-deamon
CD Demo-rest/.gradle/build/libs \
CMD["java","-jar","demo1-1.1.0.jar"]