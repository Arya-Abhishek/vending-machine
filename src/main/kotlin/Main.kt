package org.example

import org.example.vendingmachine.VendingMachine
import org.example.vendingmachine.entities.UserInput

fun main() {
    println("Hello World!")

    val vendingMachine = VendingMachine()

    // 0. Stock up inventory
    vendingMachine.inventory.stockUp()

    // 1. display inventory
    vendingMachine.displayInventory()

    // 2. select insert coin button
    vendingMachine.insertCoinBtn()
    vendingMachine.insertCoin()

    // 3. user's input as product code and map of <coin value, no of each coin>
    // coins: 1, 5, 10, 25, 50
    val userInput = UserInput(mapOf(10 to 2, 25 to 1), "101")

    vendingMachine.userInput = userInput

    // 4. select product button
    vendingMachine.selectProductBtn()

    // 5. select product
    vendingMachine.selectProduct()

    // 6. dispense product
    vendingMachine.dispenseProduct()
}

