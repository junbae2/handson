package com.g12.greenhabits.jpa.repository

import com.g12.greenhabits.jpa.entity.UserStockEntity
import org.springframework.data.repository.CrudRepository

interface UserStockRepository : CrudRepository<UserStockEntity, Long> {
    fun findByUserId(userId: Long): Iterable<UserStockEntity>
}