package com.g12.stock

import com.g12.stock.jpa.entity.UserEntity
import com.g12.stock.jpa.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@DataJpaTest
class UserRepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository
) {

    @Test
    fun `When findByEmail then return User`() {
        val user = UserEntity("test@mail.com", "tester1", "teste user 1", LocalDateTime.now())
        entityManager.persist(user)

        entityManager.flush()

        val fund = userRepository.findByEmail("test@mail.com")
        assertTrue(fund?.email == user.email)
    }
}