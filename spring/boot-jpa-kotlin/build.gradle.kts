import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

group = "com.g12"
version = "1.0-SNAPSHOT"
description = "boot-jpa-kotlin"

plugins {

    kotlin("plugin.jpa") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin

    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}
