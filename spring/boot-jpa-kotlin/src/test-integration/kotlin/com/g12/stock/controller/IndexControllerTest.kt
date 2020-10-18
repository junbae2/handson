package com.g12.stock.controller

import com.g12.stock.GreenHabitsApplication
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [GreenHabitsApplication::class]
)
class IndexControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @Test
    fun `Assert index page title, content and status code` () {
        val entity = restTemplate.getForEntity<String>("/")
        assertTrue { entity.statusCode == HttpStatus.OK }
        assertTrue { entity.body?.contains("<h1>Green Habits</h1>") == true}
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }

}