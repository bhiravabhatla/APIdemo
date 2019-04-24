FROM maven:3.6.0-slim as builder
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:8-jre-alpine
RUN mkdir /consumer
COPY --from=builder /tmp/target/*.jar /consumer/.
WORKDIR /consumer
EXPOSE 6060
CMD java -jar *.jar
