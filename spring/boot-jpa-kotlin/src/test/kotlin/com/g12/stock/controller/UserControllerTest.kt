package com.g12.stock.controller

import com.g12.stock.jpa.entity.UserEntity
import com.g12.stock.jpa.repository.UserRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.time.LocalDateTime

@WebMvcTest(UserController::class)
class UserControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var userRepository: UserRepository

    @Test
    fun `List users`() {
        val jbb = UserEntity("jbb@naver.com", "jbb", "jbb!", LocalDateTime.now())
        val sjy = UserEntity("sjy@naver.com", "sjy", "sjy!", LocalDateTime.now())

        every { userRepository.findAll() } returns listOf(jbb, sjy)

        mockMvc.perform(get("/api/user").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("\$.[0].email").value(jbb.email))
                .andExpect(jsonPath("\$.[1].email").value(sjy.email))
    }
}