package org.example.vendingmachine.entities

data class UserInput (
    val coins: Map<Int, Int>,
    var productCode: String ?= null
) {
    val totalAmount: Int

    init {
        totalAmount = coins.entries.sumOf { it.key * it.value }
    }
}
