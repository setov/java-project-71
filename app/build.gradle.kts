plugins {
    id("java")
    application
}

application { mainClass.set("hexlet.code.App") }


group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation ("info.picocli:picocli:4.7.6")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.16.0")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.16.0")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.18.1")
    implementation ("org.apache.commons:commons-lang3:3.14.0")
    implementation ("commons-io:commons-io:2.18.0")
}


tasks.test {
    useJUnitPlatform()
}