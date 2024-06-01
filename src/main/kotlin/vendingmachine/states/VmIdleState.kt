package org.example.vendingmachine.states

import org.example.vendingmachine.VendingMachine

class VmIdleState(
    private val vendingMachine: VendingMachine
) : IVmStates {

    override fun insertCoinBtn() {
        println("Right now in IDEAL STATE but going into AWAITING PAYMENT STATE to insert coin")
        this.vendingMachine.changeState()
    }

    override fun insertCoin() {
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
