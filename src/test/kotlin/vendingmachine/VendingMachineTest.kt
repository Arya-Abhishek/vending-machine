package vendingmachine

import org.example.vendingmachine.VendingMachine
import org.example.vendingmachine.entities.UserInput
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class VendingMachineTest {
    @Test
    fun `successful product selection and dispense success`() {
        val vendingMachine = VendingMachine()
        vendingMachine.inventory.stockUp()
        val userInput = UserInput(mapOf(10 to 2, 25 to 1), "101")   // Selecting product 101, Coke
        vendingMachine.userInput = userInput

        vendingMachine.insertCoinBtn()
        vendingMachine.insertCoin()
        vendingMachine.selectProductBtn()
        vendingMachine.selectProduct()
        vendingMachine.dispenseProduct()

        assertEquals(4, vendingMachine.inventory.getProductQuantity("101"))
    }

    @Test
    fun `user cancels the order in product selection state`() {
        val vendingMachine = VendingMachine()
        vendingMachine.inventory.stockUp()
        val userInput = UserInput(mapOf(10 to 2, 25 to 1), "101")   // Selecting product 101, Coke
        vendingMachine.userInput = userInput

        vendingMachine.insertCoinBtn()
        vendingMachine.insertCoin()
        vendingMachine.selectProductBtn()
        vendingMachine.pressCancelBtn()

        assertEquals(5, vendingMachine.inventory.getProductQuantity("101"))
    }

    @Test
    fun `user cancels the order in awaiting payment state`() {
        val vendingMachine = VendingMachine()
        vendingMachine.inventory.stockUp()
        val userInput = UserInput(mapOf(10 to 2, 25 to 1), "101")   // Selecting product 101, Coke
        vendingMachine.userInput = userInput

        vendingMachine.insertCoinBtn()
        vendingMachine.insertCoin()
        vendingMachine.pressCancelBtn()

        assertEquals(5, vendingMachine.inventory.getProductQuantity("101"))
    }

    @Test
    fun `user selects product out of stock`() {
        val vendingMachine = VendingMachine()
        vendingMachine.inventory.stockUp()
        vendingMachine.inventory.updateProductQuantity("102", 0)  // Pepsi out of stock
        val userInput = UserInput(mapOf(10 to 2, 25 to 1), "102")   // Selecting product 102, Pepsi
        vendingMachine.userInput = userInput

        vendingMachine.insertCoinBtn()
        vendingMachine.insertCoin()
        vendingMachine.selectProductBtn()
        vendingMachine.selectProduct()

        assertEquals(0, vendingMachine.inventory.getProductQuantity("102"))
    }

    @Test
    fun `user selects product with insufficient amount`() {
        val vendingMachine = VendingMachine()
        vendingMachine.inventory.stockUp()
        val userInput = UserInput(mapOf(10 to 1, 25 to 1), "103")   // Selecting product 103, Coke
        vendingMachine.userInput = userInput

        vendingMachine.insertCoinBtn()
        vendingMachine.insertCoin()
        vendingMachine.selectProductBtn()
        vendingMachine.selectProduct()

        assertEquals(5, vendingMachine.inventory.getProductQuantity("101"))
    }
}
