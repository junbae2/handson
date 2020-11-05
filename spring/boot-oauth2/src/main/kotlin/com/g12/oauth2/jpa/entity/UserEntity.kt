package com.g12.oauth2.jpa.entity

import java.io.Serializable
import javax.persistence.*

@Entity(name = "user")
@Table
class UserEntity(
        @Column(name = "name", nullable = false, length = 50)
        var name: String,

        @Column(name = "email", nullable = false, length = 256)
        var email: String,

        @Column(name = "picture", length = 1000)
        var picture: String,

        @Enumerated(EnumType.STRING)
        @Column(name = "role", nullable = false, length = 20)
        var role: Role,

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0

) : Serializable {

    enum class Role(val roleValue: String) {
        GUEST("ROLE_GUEST"), USER("ROLE_USEr")
    }
}