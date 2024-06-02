package org.example.vendingmachine.states

import org.example.vendingmachine.VendingMachine
import org.example.vendingmachine.entities.UserInput
import org.example.vendingmachine.inventory.Inventory

class VmSelectionState(
    private val vendingMachine: VendingMachine,
    private val inventory: Inventory
) : IVmStates {
    override fun insertCoinBtn() {
        println("Not supported in this state")
    }

    override fun insertCoin(userInput: UserInput) {
        println("Not supported in this state")
    }

    override fun selectProductBtn() {
        println("In selection state, select the product")
    }

    override fun selectProduct(userInput: UserInput) {
        // user given productCode in `userInput.productCode` as string
        // NOTE: Before, selectProduct is called, user had given the product code
        userInput.productCode ?. let { productCode ->
            val currentProduct = inventory.getProduct(productCode)
            val currentProductQuantity = inventory.getProductQuantity(productCode)

            when {
                currentProduct == null -> {
                    println("Product code not valid")
                    vendingMachine.changeState(VmIdleState(vendingMachine))
                }
                currentProductQuantity == 0 -> {
                    println("Product out of stock")
                    vendingMachine.changeState(VmIdleState(vendingMachine))
                }
                userInput.totalAmount >= currentProduct.price -> {
                    println("Product dispensed")
                    inventory.updateProductQuantity(productCode, currentProductQuantity - 1)
                    refund(userInput)
                    vendingMachine.changeState(VmIdleState(vendingMachine))
                }
                else -> {
                    println("Insufficient amount, please insert more coins")
                    vendingMachine.changeState(VmAwaitingPaymentState(vendingMachine))
                }
            }
        } ?: run {
            println("Product code not valid")
            vendingMachine.changeState(VmIdleState(vendingMachine))
        }
    }

    override fun pressCancelBtn() {
        vendingMachine.userInput ?. let {
            refund(it)
        }
        vendingMachine.changeState(VmIdleState(vendingMachine))
    }

    override fun refund(userInput: UserInput) {
        // will give refund here: dispense all user inserted coins
        println("Refund Total amount: ${userInput.totalAmount}")
        userInput.coins.map { (coin, qty) ->
            println("Refund Coin: $coin, Quantity: $qty")
        }
    }

    override fun dispenseProduct() {
        println("Not supported in this state")
    }
}
