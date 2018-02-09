FROM java:8-jre

# Copy your fat jar to the container
COPY target/scheduler-1.0-SNAPSHOT.jar .
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar scheduler-1.0-SNAPSHOT.jar"]