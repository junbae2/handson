package com.g12.stock.controller

import com.g12.stock.StockApplication
import com.g12.stock.jpa.entity.UserEntity
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [StockApplication::class]
)
class UserControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @Test
    fun `Assert user info and status code`() {
        val response = restTemplate.getForEntity("/api/user", Array<UserEntity>::class.java)
        val body = response.body?.toList()

        assertTrue { response.statusCode == HttpStatus.OK }
        assertNotNull { body }

        assertTrue { body?.get(0)?.email == "user1@naver.com" }
        assertTrue { body?.get(0)?.name == "junsang" }
        assertTrue { body?.get(0)?.description == "good investor" }
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }
}