package org.example.vendingmachine.states

import org.example.vendingmachine.VendingMachine
import org.example.vendingmachine.entities.UserInput
import org.example.vendingmachine.inventory.Inventory

class VmDispenseState(
    private val vendingMachine: VendingMachine
) : IVmStates {
    override fun insertCoinBtn() {
        println("Please wait, dispensing product")
    }

    override fun insertCoin() {
        println("Please wait, dispensing product")
    }

    override fun selectProductBtn() {
        println("Please wait, dispensing product")
    }

    override fun selectProduct() {
        println("Please wait, dispensing product")
    }

    override fun pressCancelBtn() {
        println("Please wait, dispensing product")
    }

    override fun refund() {
        println("Please wait, dispensing product")
    }

    override fun dispenseProduct() {
        vendingMachine.userInput?.productCode ?. let {
            println("Product ${vendingMachine.inventory.getProduct(it)?.name} dispensed successfully")
        }
        dispenseChange()
        println("Thank you for using the vending machine")
        vendingMachine.changeState(VmIdleState(vendingMachine))
    }

    private fun dispenseChange() {
        vendingMachine.userInput ?. let {
            vendingMachine.inventory.getProduct(it.productCode!!)?.price?.let { price ->
                val change = it.totalAmount - price
                println("Change dispensed: $change")
            } ?: run {
                // handle the case where price is null
                println("Something wen wrong! Please contact the vending machine operator")
            }
        }
    }
}
