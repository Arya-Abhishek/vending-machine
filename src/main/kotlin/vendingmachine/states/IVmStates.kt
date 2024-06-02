package org.example.vendingmachine.states

import org.example.vendingmachine.entities.UserInput

interface IVmStates {
    fun insertCoinBtn()
    fun insertCoin()
    fun selectProductBtn()
    fun selectProduct()
    fun pressCancelBtn()
    fun refund()
    fun dispenseProduct()
}
