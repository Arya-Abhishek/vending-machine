package org.example.vendingmachine.states

import org.example.vendingmachine.entities.UserInput

interface IVmStates {
    fun insertCoinBtn()
    fun insertCoin(userInput: UserInput)
    fun selectProductBtn()
    fun selectProduct(userInput: UserInput)
    fun pressCancelBtn()
    fun refund()
    fun dispenseProduct()
}
