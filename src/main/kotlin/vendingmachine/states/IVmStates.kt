package org.example.vendingmachine.states

interface IVmStates {
    fun insertCoinBtn()
    fun insertCoin(userCoins: List<Int>)
    fun pressCancelBtn()
    fun refund()
    fun dispenseProduct()
}
