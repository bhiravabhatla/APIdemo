FROM maven:3.6.0-slim as builder
WORKDIR /tmp
COPY pom.xml /tmp/
RUN mvn -B  dependency:go-offline
COPY src/ /tmp/src
RUN mvn -B clean package -DskipTests

FROM openjdk:8-jre-alpine
RUN mkdir /producer
COPY --from=builder /tmp/target/*SNAPSHOT.jar /producer/.
WORKDIR /producer
EXPOSE 6050
CMD java -jar *.jar
