FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
COPY ./target/geekspace-api.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
CMD ["java", "-jar", "geekspace-api.jar"]
