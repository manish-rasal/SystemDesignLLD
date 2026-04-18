package main.java.LLD.EnhancedVendingMachine;

public interface State {
    void selectSlot(VendingMachine vendingMachine, int slotId);
    void makePayment(VendingMachine vendingMachine, PaymentMethod paymentMethod);
    void dispenseItem(VendingMachine vendingMachine);
    void returnChange(VendingMachine vendingMachine);
}
