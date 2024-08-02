FROM eclipse-temurin:21-jdk

COPY . ./

RUN ./gradlew installDist

CMD ./build/install/app/bin/app