val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val prometeus_version: String by project
val exposed_version: String by project
val h2_version: String by project
val kodein_version: String by project
val hikari_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "demo"
version = "0.0.1"
application {
    mainClass.set("ktor.demo.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-auth-jwt:$ktor_version")
    implementation("io.ktor:ktor-server-host-common:$ktor_version")
    implementation("io.ktor:ktor-metrics-micrometer:$ktor_version")
    implementation("io.micrometer:micrometer-registry-prometheus:$prometeus_version")
    implementation("io.ktor:ktor-jackson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.jetbrains.exposed:exposed:$exposed_version")
    implementation("com.h2database:h2:$h2_version")
    implementation("org.kodein.di:kodein-di-generic-jvm:$kodein_version")
    implementation("com.zaxxer:HikariCP:$hikari_version")
    implementation("org.postgresql:postgresql:42.2.23")
    //Client dependencies
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-apache:$ktor_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "ktor.demo.ApplicationKt"
    }
}

tasks{
    shadowJar {
        manifest {
            attributes(Pair("Main-Class", "ktor.demo.ApplicationKt"))
        }
    }
}
