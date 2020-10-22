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
        var userId: Long,

        @Column(name = "stock_id", nullable = false)
        var stockId: Long,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "stock_id", updatable = false, insertable = false)
        var stock: StockEntity? = null,

        @Column(name = "traded_at", nullable = false)
        var tradedAt: LocalDateTime,

        @Column(name = "sold_at")
        var soldAt: LocalDateTime? = null,

        @Id @GeneratedValue
        var id: Long = 0
) : Serializable