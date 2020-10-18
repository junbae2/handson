package com.g12.greenhabits.jpa.entity

import java.io.Serializable
import javax.persistence.*

@Entity(name = "stock")
@Table
class StockEntity(

        @Column(name = "market", nullable = false, length = 25)
        val market: String,

        @Column(name = "code", nullable = false, length = 20)
        val code: String,

        @Column(name = "name", nullable = false, length = 50)
        val name: String,

        @Column(name = "industry", nullable = false, length = 50)
        val industry: String,

        @Id @GeneratedValue
        val id: Long? = null
) : Serializable