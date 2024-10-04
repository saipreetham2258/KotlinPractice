plugins {
    kotlin("jvm") version "2.0.10"
    kotlin("plugin.serialization") version "1.8.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.litote.kmongo:kmongo:5.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    implementation("org.litote.kmongo:kmongo-coroutine-serialization:4.11.0")
//    implementation("com.vdurmont:emoji-java:5.1.1")
//    implementation("org.slf4j:slf4j-api:1.7.30")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(18)
}