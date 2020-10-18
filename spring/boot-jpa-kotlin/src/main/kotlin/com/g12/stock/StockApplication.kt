package com.g12.stock

import com.g12.stock.jpa.entity.StockEntity
import com.g12.stock.jpa.entity.UserEntity
import com.g12.stock.jpa.entity.UserStockEntity
import com.g12.stock.jpa.repository.StockRepository
import com.g12.stock.jpa.repository.UserRepository
import com.g12.stock.jpa.repository.UserStockRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import javax.transaction.Transactional

@SpringBootApplication
class StockApplication

fun main(args: Array<String>) {
    runApplication<StockApplication>(*args)
}

@Configuration
class Configuration {

    @Bean
    @Transactional
    fun databaseInitializer(
            userRepository: UserRepository,
            stockRepository: StockRepository,
            userStockRepository: UserStockRepository) = ApplicationRunner {

        var user = userRepository.save(UserEntity(
                "user1@naver.com",
                "junsang",
                "good investor",
                LocalDateTime.now())
        )

        var stocks = stockRepository.saveAll(
                listOf(
                        StockEntity("kospi", "030720", "동원수산", "fishing"),
                        StockEntity("kospi", "017810", "풀무원", "food and drink"),
                        StockEntity("kospi", "271980", "제일약품", "medicine"))
        )

        for (s in stocks) {
            userStockRepository.save(UserStockEntity(user.id, s.id, tradedAt = LocalDateTime.now()))
        }
    }
}
