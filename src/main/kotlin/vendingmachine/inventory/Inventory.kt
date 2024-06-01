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
        inventory[code] = Pair(inventory[code]?.first!!, quantity)
    }

    fun removeProduct(code: String) {
        inventory.remove(code)
    }
}