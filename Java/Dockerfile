# Use an OpenJDK Runtime as a parent image
FROM openjdk:8-jdk-alpine

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run app.jar when the container launches
ARG JAR_FILE=target/mailsorter-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} mailsorter.jar
ENTRYPOINT ["java","-jar","/mailsorter.jar"]