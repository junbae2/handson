group = "com.g12"
version = "1.0-SNAPSHOT"
description = "boot-oauth2"

plugins {
    kotlinSpringBootPlugin()
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}
