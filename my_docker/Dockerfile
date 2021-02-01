FROM openjdk:8
RUN mkdir /usr/src/myapp
COPY /target/my_docker-1.0-SNAPSHOT.jar /usr/src/myapp
WORKDIR /usr/src/myapp


ENV AGE=18 \
    NAME="rdw"

CMD java -jar my_docker-1.0-SNAPSHOT.jar --age $AGE --name $NAME