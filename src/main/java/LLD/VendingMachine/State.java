package main.java.LLD.VendingMachine;

public interface State {
    void selectItem(VendingMachine vendingMachine, int slotId);
    void insertCoins(VendingMachine vendingMachine, Coin coin);
    void dispenseItem(VendingMachine vendingMachine);
    void returnChange(VendingMachine vendingMachine);
}
