package org.example.vendingmachine.states

import org.example.vendingmachine.VendingMachine
import org.example.vendingmachine.entities.UserInput

class VmAwaitingPaymentState(
    private val vendingMachine: VendingMachine
) : IVmStates {

    override fun insertCoinBtn() {
        println("Already pressed, waiting for coins to be inserted")
    }

    override fun insertCoin() {
        println("Now pls insert coins of denomination 1, 5, 10, 25, 50")
    }

    override fun selectProductBtn() {
        println("Coins inserted, now select the product")
        this.vendingMachine.changeState(VmSelectionState(this.vendingMachine))
    }

    override fun selectProduct() {
        println("Not supported in this state")
    }

    override fun pressCancelBtn() {
        println("Not supported in this state")
    }

    override fun refund() {
        println("Not supported in this state")
    }

    override fun dispenseProduct() {
        println("Not supported in this state")
    }
}
