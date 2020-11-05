group = "com.g12"
version = "1.0-SNAPSHOT"
description = "boot-jpa-kotlin"

plugins {
    kotlinSpringBootPlugin()
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

sourceSets {
    create("integrationTest") {
        java.srcDir("src/test-integration/java")
        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
            kotlin.srcDir("src/test-integration/kotlin")
        }

        resources.srcDir("src/test-integration/resources")

        compileClasspath = sourceSets["main"].output + configurations["testRuntimeClasspath"]
        runtimeClasspath = output + compileClasspath
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage")
        exclude(module = "junit")
        exclude(module = "mockito-core")
    }
    testImplementation("org.testcontainers:junit-jupiter:${Versions.testContainer}")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.ninja-squad:springmockk:1.1.3")
}

tasks {
    test {
        useJUnitPlatform()
        testLogging.showExceptions = true
    }

    register<Test>("integrationTest") {
        description = "run it tests."
        group = "verification"
        testClassesDirs = sourceSets["integrationTest"].output.classesDirs
        classpath = sourceSets["integrationTest"].runtimeClasspath
        useJUnitPlatform()
        mustRunAfter(test)
    }
}
