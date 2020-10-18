package com.g12.greenhabits.jpa.repository

import com.g12.greenhabits.jpa.entity.StockEntity
import org.springframework.data.repository.CrudRepository

interface StockRepository : CrudRepository<StockEntity, Long>