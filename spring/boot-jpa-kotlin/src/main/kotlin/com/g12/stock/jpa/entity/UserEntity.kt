package com.g12.stock.jpa.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "user")
@Table(indexes = [
    Index(name = "name", columnList = "name")
],
        uniqueConstraints = [
            UniqueConstraint(name = "email", columnNames = ["email"])
        ])
class UserEntity(
        @Column(name = "email", nullable = false, length = 255)
        var email: String,

        @Column(name = "name", nullable = false, length = 255)
        var name: String,

        @Column(name = "description", length = 1000)
        var description: String? = null,

        @Column(name = "created_at")
        var createdAt: LocalDateTime? = null,

        @Id @GeneratedValue
        var id: Long = 0

) : Serializable