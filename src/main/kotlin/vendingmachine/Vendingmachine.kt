package org.example.vendingmachine

import org.example.vendingmachine.entities.UserInput
import org.example.vendingmachine.states.IVmStates
import org.example.vendingmachine.states.VmIdleState

class VendingMachine {
    private var state: IVmStates
    var userInput: UserInput ? = null

    init {
        state = VmIdleState(this)
    }

    fun setUserInput(userInput: UserInput) {
        this.userInput = userInput
    }

    fun changeState(state: IVmStates) {
        this.state = state
    }
}
