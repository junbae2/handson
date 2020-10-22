package com.g12.stock.repository

import com.g12.stock.jpa.entity.StockEntity
import com.g12.stock.jpa.entity.UserEntity
import com.g12.stock.jpa.entity.UserStockEntity
import com.g12.stock.jpa.repository.UserStockRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@DataJpaTest
class UserStockRepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val userStockRepository: UserStockRepository
) {

    @Test
    fun `When findAll stocks then return stock list`() {
        val stock1 = entityManager.persist(StockEntity("kospi", "030720", "동원수산", "fishing"))
        val stock2 = entityManager.persist(StockEntity("kospi", "017810", "풀무원", "food and drink"))
        val stock3 = entityManager.persist(StockEntity("kospi", "271980", "제일약품", "medicine"))

        assertEquals(stock1.code, "030720")
        assertEquals(stock2.code, "017810")
        assertEquals(stock3.code, "271980")
    }

    @Test
    fun `When findByUserId then return user stocks`() {
        val user = entityManager.persist(UserEntity(
                "user1@naver.com",
                "junsang",
                "good investor",
                LocalDateTime.now()))

        val stock1 = entityManager.persist(StockEntity("kospi", "030720", "동원수산", "fishing"))
        val stock2 = entityManager.persist(StockEntity("kospi", "017810", "풀무원", "food and drink"))
        val stock3 = entityManager.persist(StockEntity("kospi", "271980", "제일약품", "medicine"))

        val userStock1 = entityManager.persist(UserStockEntity(user.id, stock1.id, tradedAt = LocalDateTime.now()))
        val userStock2 = entityManager.persist(UserStockEntity(user.id, stock2.id, tradedAt = LocalDateTime.now()))
        val userStock3 = entityManager.persist(UserStockEntity(user.id, stock3.id, tradedAt = LocalDateTime.now()))

        val foundUserStocks = userStockRepository.findByUserId(user.id)

        assertEquals(userStock1.stockId, foundUserStocks[0].stockId)
        assertEquals(userStock2.stockId, foundUserStocks[1].stockId)
        assertEquals(userStock3.stockId, foundUserStocks[2].stockId)
    }
}