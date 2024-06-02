package org.example.vendingmachine.inventory

import org.example.vendingmachine.entities.Product

class Inventory {
    private val inventory: MutableMap<String, Pair<Product, Int>> = mutableMapOf()

    fun addProduct(product: Product, quantity: Int) {
        inventory[product.code] = Pair(product, quantity)
    }

    fun getProduct(code: String): Product? {
        return inventory[code]?.first
    }

    fun getProductQuantity(code: String): Int {
        return inventory[code]?.second ?: 0
    }

    fun updateProductQuantity(code: String, quantity: Int) {
        inventory[code]?.let {
            inventory[code] = Pair(it.first, quantity)
        } ?: println("Product code not found: $code")
    }

    fun removeProduct(code: String) {
        inventory.remove(code)
    }

    fun displayInventory() {
        inventory.forEach { (code, product) ->
            println("Product code: $code | Product name: ${product.first.name} | Product price: ${product.first.price} | Product quantity: ${product.second}")
        }
    }

    fun stockUp() {
        addProduct(Product("101", "Coke", 25), 5)
        addProduct(Product("102", "Pepsi", 35), 5)
        addProduct(Product("103", "Soda", 45), 5)
    }
}
