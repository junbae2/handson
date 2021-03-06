package com.g12.stock.controller

import com.g12.stock.jpa.entity.UserEntity
import com.g12.stock.jpa.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/user")
class UserController(val repository: UserRepository) {

    @GetMapping
    fun findAll(): MutableIterable<UserEntity> = repository.findAll()

    @GetMapping("/{email}")
    fun findOne(@PathVariable email: String) = repository.findByEmail(email)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does net exist")
}