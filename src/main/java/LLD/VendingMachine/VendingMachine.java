package main.java.LLD.VendingMachine;

public class VendingMachine {
    private State state;
    private Inventory inventory;
    private int balance;
    private int selectedSlot;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        this.state = new IdleState();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setSelectedSlot(int slotId) {
        this.selectedSlot = slotId;
    }

    public int getSelectedSlot() {
        return selectedSlot;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addBalance(int value) {
        balance += value;
    }

    public boolean hasSufficientBalance() {
        return balance >= inventory.getItem(selectedSlot).getPrice();
    }

    public int getChange() {
        return balance - inventory.getItem(selectedSlot).getPrice();
    }

    public void resetTransaction() {
        balance = 0;
        selectedSlot = -1;
    }

    public synchronized void selectItem(int slotId) {
        state.selectItem(this, slotId);
    }

    public synchronized void insertCoin(Coin coin) {
        state.insertCoins(this, coin);
    }

    public synchronized void dispense() {
        state.dispenseItem(this);
    }

    public synchronized void returnChange() {
        state.returnChange(this);
    }
}
