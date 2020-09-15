package com.g12.greenhabits.jpa.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "user")
@Table(indexes = [
    Index(name = "name", columnList = "name")
],
uniqueConstraints = [
    UniqueConstraint(name = "email", columnNames = ["email"])
])
class UserEntity(
        @Id @GeneratedValue
        var id: Long,

        @Column(name = "email", nullable = false, length = 255)
        var email: String,

        @Column(name = "name", nullable = false, length = 255)
        var name: String,

        @Column(name = "description", length = 1000)
        var description: String? = null,

        @Column(name = "created_at")
        var createdAt: LocalDateTime? = null
) {

}