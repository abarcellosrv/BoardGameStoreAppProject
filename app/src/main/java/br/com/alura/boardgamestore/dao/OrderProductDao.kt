package br.com.alura.boardgamestore.dao

import br.com.alura.boardgamestore.model.OrderItems
import br.com.alura.boardgamestore.model.Product
import java.math.BigDecimal

class OrderProductDao {

    fun addProductToOrder(orderItem: OrderItems){
        orderItems.add(orderItem)
    }

    fun searchAll():List<OrderItems>{
        return orderItems.toList()
    }

    companion object{
        private val orderItems = mutableListOf<OrderItems>(
            OrderItems(
                Product(
                    name = "Super Cool Game",
                    description = "A Game so cool you won't believe!",
                    price = BigDecimal("399.99"),
                    numberofPlayers = 1
                )
            )
        )
    }
}