FROM gradle:8.9-jdk21

COPY . ./

RUN ./gradlew installDist

CMD ./build/install/app/bin/app