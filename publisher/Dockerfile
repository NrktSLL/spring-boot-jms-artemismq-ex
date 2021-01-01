FROM adoptopenjdk/openjdk11:alpine as build
RUN apk add --no-cache maven
WORKDIR /project
COPY . /project
RUN mvn package -Dmaven.test.skip=true
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/project/target/publisher-0.0.1-SNAPSHOT.jar"]
