package main.java.LLD.VendingMachine;

public class DispenseState implements State{
    @Override
    public void selectItem(VendingMachine vendingMachine, int slotId) {

    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) {

    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        vendingMachine.getInventory().dispense(vendingMachine.getSelectedSlot());
        System.out.println("Item Dispensed");
        vendingMachine.setState(new ReturnChangeState());
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {

    }
}
