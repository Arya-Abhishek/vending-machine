package org.example.vendingmachine.entities

data class UserInput (
    val coins: Map<Int, Int>,       // <coin value, number of coins>
    var productCode: String ?= null
) {
    val totalAmount: Int

    init {
        totalAmount = coins.entries.sumOf { it.key * it.value }
    }
}
