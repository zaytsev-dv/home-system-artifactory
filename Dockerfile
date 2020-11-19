FROM maven:3.6-jdk-8-alpine AS builder

WORKDIR /src
COPY . .
RUN mvn clean install

FROM java:8-jre-alpine
COPY --from=builder /src/target/home-system-artifactory.jar /home-system-artifactory.jar
ENTRYPOINT ["java","-jar","home-system-artifactory.jar"]
