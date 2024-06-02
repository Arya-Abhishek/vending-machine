package org.example.vendingmachine.states

import org.example.vendingmachine.VendingMachine
import org.example.vendingmachine.entities.UserInput
import org.example.vendingmachine.inventory.Inventory

class VmDispenseState(
    private val vendingMachine: VendingMachine,
    private val inventory: Inventory,
    private val userInput: UserInput
) : IVmStates {
    override fun insertCoinBtn() {
        println("Please wait, dispensing product")
    }

    override fun insertCoin(userInput: UserInput) {
        println("Please wait, dispensing product")
    }

    override fun selectProductBtn() {
        println("Please wait, dispensing product")
    }

    override fun selectProduct(userInput: UserInput) {
        println("Please wait, dispensing product")
    }

    override fun pressCancelBtn() {
        println("Please wait, dispensing product")
    }

    override fun refund(userInput: UserInput) {
        println("Please wait, dispensing product")
    }

    override fun dispenseProduct() {
        userInput.productCode ?. let {
            println("Product ${inventory.getProduct(it)?.name} dispensed successfully")
        }
        println("Thank you for using the vending machine")
        vendingMachine.changeState(VmIdleState(vendingMachine))
    }
}
