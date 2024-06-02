package org.example.vendingmachine.states

import org.example.vendingmachine.VendingMachine
import org.example.vendingmachine.entities.UserInput

class VmAwaitingPaymentState(
    private val vendingMachine: VendingMachine
) : IVmStates {

    override fun insertCoinBtn() {
        println("Already pressed, waiting for coins to be inserted")
    }

    override fun insertCoin(userInput: UserInput) {
        println("Now pls insert coins of denomination 1, 5, 10, 25, 50")
    }

    override fun selectProductBtn() {
        println("Coins inserted, now select the product")
        this.vendingMachine.changeState(VmAwaitingPaymentState(this.vendingMachine))
    }

    override fun selectProduct(userInput: UserInput) {
        println("Not supported in this state")
    }

    override fun pressCancelBtn() {
        println("Not supported in this state")
    }

    override fun refund(userInput: UserInput) {
        println("Not supported in this state")
    }

    override fun dispenseProduct() {
        println("Not supported in this state")
    }
}
