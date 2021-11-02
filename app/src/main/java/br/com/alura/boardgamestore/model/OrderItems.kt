package br.com.alura.boardgamestore.model

class OrderItems(product: Product) {
    val name = product.name
    val price = product.price
}