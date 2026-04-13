package main.java.LLD.VendingMachine;

public class IdleState implements State{

    @Override
    public void selectItem(VendingMachine vendingMachine, int slotId) {
        if(!vendingMachine.getInventory().isAvailable(slotId)) {
            throw new RuntimeException("Item unavailable");
        }
        vendingMachine.setSelectedSlot(slotId);
        vendingMachine.setState(new ReadyState());
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) {
        throw new RuntimeException("Select an item first");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        throw new RuntimeException("No item selected");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        throw new RuntimeException("No change to return");
    }
}
