package com.g12.stock.controller

import com.g12.stock.jpa.entity.UserStockEntity
import com.g12.stock.jpa.repository.UserStockRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDateTime

@WebMvcTest(UserStockController::class)
class UserStockControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var userStockRepository: UserStockRepository

    @Test
    fun `List users`() {
        val jbbStock1 = UserStockEntity(1L, 1L, tradedAt = LocalDateTime.now())
        val jbbStock2 = UserStockEntity(1L, 2L, tradedAt = LocalDateTime.now())

        every { userStockRepository.findByUserId(1L) } returns listOf(jbbStock1, jbbStock2)

        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/1/stock").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.[0].stockId").value(jbbStock1.stockId))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.[1].stockId").value(jbbStock2.stockId))
    }
}