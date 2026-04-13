package main.java.LLD.VendingMachine;

public class VendingMachineDemo {

    public static void main(String[] args) {

        // Step 1: Create inventory and add items
        Inventory inventory = new Inventory();

        inventory.addSlot(1, new Slot(new Item("Coke", 25), 5));
        inventory.addSlot(2, new Slot(new Item("Pepsi", 30), 3));
        inventory.addSlot(3, new Slot(new Item("Chips", 20), 2));

        // Step 2: Initialize vending machine
        VendingMachine vendingMachine = new VendingMachine(inventory);

        vendingMachine.selectItem(1);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.dispense();
        vendingMachine.returnChange();
    }
}
