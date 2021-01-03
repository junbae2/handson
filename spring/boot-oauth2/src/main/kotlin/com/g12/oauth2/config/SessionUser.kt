package com.g12.oauth2.config

import com.g12.oauth2.jpa.entity.UserEntity
import java.io.Serializable

class SessionUser(val name: String, val email: String, val picture: String) : Serializable

fun UserEntity.toSessionUser() = SessionUser(name, email, picture)