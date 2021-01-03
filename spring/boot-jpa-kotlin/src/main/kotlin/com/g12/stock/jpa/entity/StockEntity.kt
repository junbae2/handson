package com.g12.stock.jpa.entity

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "stock")
@Table(
        uniqueConstraints = [
                UniqueConstraint(name = "market_code", columnNames = ["market", "code"])
        ]
)
class StockEntity(
        @Column(name = "market", nullable = false, length = 25)
        var market: String,

        @Column(name = "code", nullable = false, length = 20)
        var code: String,

        @Column(name = "name", nullable = false, length = 50)
        var name: String,

        @Column(name = "industry", nullable = false, length = 50)
        var industry: String,

        @Id @GeneratedValue
        var id: Long = 0

) : Serializable