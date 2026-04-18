package main.java.LLD.EnhancedVendingMachine;

public class VendingMachine {

    private Inventory inventory;
    private State state;
    private int balance;
    private int selectedSlot;
    private PaymentMethod paymentMethod;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        this.state = new IdleState();
    }

    public void setSelectedSlot(int slotId) {
        this.selectedSlot = slotId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean hasSufficientBalance() {
        return balance >= inventory.getItem(selectedSlot).getPrice();
    }

    public void addBalance() {
        this.balance += paymentMethod.pay();
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getSelectedSlot() {
        return selectedSlot;
    }

    public int getChange() {
        return balance - inventory.getItem(selectedSlot).getPrice();
    }

    public void refund(int amount) {
        paymentMethod.refund(amount);
    }

    public void resetTransaction() {
        balance = 0;
        selectedSlot = -1;
    }

    public synchronized void selectSlot(int slotId) {
        state.selectSlot(this, slotId);
    }

    public synchronized void makePayment(PaymentMethod paymentMethod) {
        state.makePayment(this, paymentMethod);
    }

    public synchronized void dispense() {
        state.dispenseItem(this);
    }

    public synchronized void returnChange() {
        state.returnChange(this);
    }
}
