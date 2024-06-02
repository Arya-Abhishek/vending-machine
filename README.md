# Vending Machine

This project is a low-level design of a vending machine implemented in Kotlin.

## Project Structure

The project is structured into several packages:

- `org.example`: Contains the `Main.kt` file which is the entry point of the application.
- `org.example.vendingmachine`: Contains the `VendingMachine` class which is the main class of the application.
- `org.example.vendingmachine.inventory`: Contains the `Inventory` class which manages the products in the vending machine.
- `org.example.vendingmachine.states`: Contains the state classes which define the behavior of the vending machine in different states.

## How to Run

To run the project, execute the `main` function in the `Main.kt` file.

## How to Test

To test the project, create instances of the state classes, invoke their methods, and check the results. For example, you can test the `selectProduct` functionality by creating an instance of the `VmSelectionState` class, invoking its `selectProduct` method, and checking that the product is selected correctly.

## Sequence Diagram

![Vending Machine Sequence Diagram](/assests/vending-machine-sq.png)

## License

This project is licensed under the terms of the MIT license.
