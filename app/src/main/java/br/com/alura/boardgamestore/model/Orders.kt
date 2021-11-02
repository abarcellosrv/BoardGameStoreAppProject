package br.com.alura.boardgamestore.model

import java.math.BigDecimal

class Orders(
    private val id: Int,
    products: List<Product>,
    priceTotal: BigDecimal
    ) {
}