package br.com.alura.boardgamestore.dao

import br.com.alura.boardgamestore.model.Orders
import br.com.alura.boardgamestore.model.Product
import java.math.BigDecimal

class OrderHistoryDao {

    fun addOrder(order: Orders) {
        orders.add(order)
    }

    fun searchAll(): List<Orders>{
        return orders.toList()
    }

    companion object {
        private val orders = mutableListOf<Orders>(
            Orders(
                id = 1,
                products = listOf(
                    Product(
                        "Super Cool Game",
                        "Game is Super Cool",
                        BigDecimal(199.99),
                        numberofPlayers = 1
                    )
                ),
                BigDecimal(199.99)
            )
        )
    }
}