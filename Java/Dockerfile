# Use an OpenJDK Runtime as a parent image
FROM maven:3.6-jdk-11

COPY . .

RUN mvn clean install -Dmaven.test.skip
# Run app.jar when the container launches
ARG JAR_FILE=target/mailsorter-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} mailsorter.jar
ENTRYPOINT ["java","-jar","/mailsorter.jar"]