package com.g12.stock.jpa.repository

import com.g12.stock.jpa.entity.UserStockEntity
import org.springframework.data.repository.CrudRepository

interface UserStockRepository : CrudRepository<UserStockEntity, Long> {
    fun findByUserId(userId: Long): Iterable<UserStockEntity>
}