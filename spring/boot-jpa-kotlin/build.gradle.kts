
group = "com.g12"
version = "1.0-SNAPSHOT"
description = "boot-jpa-kotlin"

plugins {
    kotlinSpringBootPlugin()
}

sourceSets {
}

dependencies {
    "implementation"("org.springframework.boot:spring-boot-starter-data-jpa")
    "implementation"("org.springframework.boot:spring-boot-starter-mustache")
    "implementation"("org.springframework.boot:spring-boot-starter-web")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin")
    "implementation"("org.jetbrains.kotlin:kotlin-reflect")
    "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    "runtimeOnly"("com.h2database:h2")
    "runtimeOnly"("org.springframework.boot:spring-boot-devtools")
    "testImplementation"("org.springframework.boot:spring-boot-starter-test")
}
