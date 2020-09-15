package com.g12.greenhabits.jpa.repository

import com.g12.greenhabits.jpa.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findByEmail(id: String): UserEntity?
}