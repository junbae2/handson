import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec

object Versions {
    const val kotlin = "1.4.10"
    const val springBoot = "2.3.1.RELEASE"
    const val springBootDependencyManager = "1.0.10.RELEASE"

    const val testContainer = "1.14.3"
}

fun PluginDependenciesSpec.kotlinSpringBootPlugin() {
    kotlinPlugin()
    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version Versions.springBootDependencyManager
}

fun PluginDependenciesSpec.kotlinPlugin() {
    kotlin("jvm")
    kotlin("plugin.jpa") version Versions.kotlin
    kotlin("plugin.allopen") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin
    kotlin("kapt")
}

