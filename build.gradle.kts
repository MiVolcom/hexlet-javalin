import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application {
    applicationName = "app"
    mainClass.set("org.example.hexlet.HelloWorld")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.h2database:h2:2.2.220")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("io.javalin:javalin:6.1.3")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("io.javalin:javalin-rendering:6.1.3")
    implementation("gg.jte:jte:3.1.9")
    compileOnly ("org.projectlombok:lombok:1.18.30")
    annotationProcessor ("org.projectlombok:lombok:1.18.30")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}