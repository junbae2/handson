import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.g12"
version = "1.0-SNAPSHOT"

plugins {
    base
    java
    kotlin("jvm") version Versions.kotlin apply false
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

allprojects {

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
}




