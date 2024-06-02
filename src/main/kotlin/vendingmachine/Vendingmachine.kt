package org.example.vendingmachine

import org.example.vendingmachine.entities.UserInput
import org.example.vendingmachine.inventory.Inventory
import org.example.vendingmachine.states.IVmStates
import org.example.vendingmachine.states.VmIdleState

class VendingMachine {
    private var state: IVmStates
    var userInput: UserInput ? = null
    val inventory = Inventory()

    init {
        state = VmIdleState(this)
    }

    fun changeState(state: IVmStates) {
        this.state = state
    }

    // can think of APIs for the vending machine
    fun insertCoinBtn() {
        state.insertCoinBtn()
    }

    fun insertCoin() {
        state.insertCoin()
    }

    fun selectProductBtn() {
        state.selectProductBtn()
    }

    fun selectProduct() {
        state.selectProduct()
    }

    fun pressCancelBtn() {
        state.pressCancelBtn()
    }

    fun dispenseProduct() {
        state.dispenseProduct()
    }

    fun displayInventory() {
        inventory.displayInventory()
    }
}
