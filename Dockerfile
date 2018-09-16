# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine

# copy application jAR (with libraries inside)
RUN mkdir /producer
WORKDIR /producer
#COPY target/libs/* /producer/
COPY target/KafkaCounterProducer-*-dependencies.jar /producer/app.jar

# specify default command
#CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/app.jar"]
CMD ["/usr/bin/java", "-jar", "/producer/app.jar"]