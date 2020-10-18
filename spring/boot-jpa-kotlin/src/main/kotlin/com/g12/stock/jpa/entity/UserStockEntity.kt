package com.g12.stock.jpa.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "user_stock")
@Table(uniqueConstraints = [
        UniqueConstraint(name = "user_id_stock_id", columnNames = ["user_id", "stock_id"])
])
class UserStockEntity(

        @Column(name = "user_id", nullable = false)
        val userId: Long,

        @Column(name = "stock_id", nullable = false)
        val stockId: Long,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id", referencedColumnName = "stock_id", updatable = false, insertable = false)
        val stock: StockEntity,

        @Column(name = "traded_at", nullable = false)
        val tradedAt: LocalDateTime,

        @Column(name = "sold_at")
        val soldAt: LocalDateTime,

        @Id @GeneratedValue
        val id: Long? = null
) : Serializable