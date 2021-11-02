package br.com.alura.boardgamestore.dao

import br.com.alura.boardgamestore.model.Product
import java.math.BigDecimal

class ProductsDao {

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun searchAll(): List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>(
            Product(
                name = "Super Cool Game",
                description = "A Game so cool you won't believe!",
                price = BigDecimal("399.99"),
                numberofPlayers = 2
            ),
            Product(
                name = "Super Cool Game",
                description = "A Game so cool you won't believe!",
                price = BigDecimal("399.99"),
                numberofPlayers = 3
            )

        )
    }

}