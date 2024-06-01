package org.example.vendingmachine.states

import org.example.vendingmachine.VendingMachine

class VmAwaitingPaymentState(
    private val vendingMachine: VendingMachine
) : IVmStates {

    override fun insertCoinBtn() {
        println("Already pressed, waiting for coins to be inserted")
    }

    override fun insertCoin(userCoins: List<Int>) {
        println("Now pls insert coins of denomination 1, 5, 10, 25, 50")

        this.vendingMachine.changeState()
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
