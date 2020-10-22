package com.g12.stock.repository

import com.g12.stock.StockApplication
import com.g12.stock.jpa.repository.UserStockRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.transaction.Transactional

@ExtendWith(SpringExtension::class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [StockApplication::class]
)
class UserStockRepositoryTest @Autowired constructor(
        val userStockRepository: UserStockRepository) {

    @Test
    @Transactional
    fun `When get stock from userStock then return stock`() {

        val foundUserStocks = userStockRepository.findByUserId(1)

        val lazyLoadedStock = foundUserStocks[0].stock

        Assertions.assertEquals(lazyLoadedStock?.id, foundUserStocks[0].stockId)
    }
}