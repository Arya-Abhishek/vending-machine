package org.example.vendingmachine.entities

data class UserInput (
    val coins: Map<Int, Int>,
    val productCode: String ?= null
) {
    val totalAmount: Int

    init {
        totalAmount = coins.entries.sumOf { it.key * it.value }
    }
}
