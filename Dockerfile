FROM frolvlad/alpine-oraclejdk8
WORKDIR /home/dev/code
COPY build/libs/audit-log-api-1.0-SNAPSHOT.jar audit-log-api.jar
COPY src/main/resources/application.properties .
COPY src/main/resources/application-dev.properties .
COPY src/main/resources/application-test.properties .
COPY src/main/resources/application-preprod.properties .
COPY src/main/resources/application-prod.properties .

EXPOSE 8080

CMD ["java", "-jar","-Xms256m", "-Xmx768m","audit-log-api.jar"]
