package org.example.vendingmachine

import org.example.vendingmachine.states.IVmStates
import org.example.vendingmachine.states.VmIdleState

class VendingMachine {
    private var state: IVmStates

    init {
        state = VmIdleState(this)
    }

    fun changeState(state: IVmStates) {
        this.state = state
    }
}
