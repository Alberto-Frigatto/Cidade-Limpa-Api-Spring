FROM eclipse-temurin:22-alpine
VOLUME /tmp
EXPOSE 8080
ADD ./target/cidadeLimpa-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
