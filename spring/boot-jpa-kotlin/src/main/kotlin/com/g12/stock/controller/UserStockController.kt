package com.g12.stock.controller

import com.g12.stock.jpa.entity.UserStockEntity
import com.g12.stock.jpa.repository.UserStockRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user/{userId}/stock")
class UserStockController(val userStockRepository: UserStockRepository) {

    @GetMapping
    fun findAll(@PathVariable userId: Long): Iterable<UserStockEntity> = userStockRepository.findByUserId(userId)
}