package com.g12.stock.jpa.repository

import com.g12.stock.jpa.entity.StockEntity
import org.springframework.data.repository.CrudRepository

interface StockRepository : CrudRepository<StockEntity, Long>