package main.java.LLD.EnhancedVendingMachine;

public class IdleState implements State{

    @Override
    public void selectSlot(VendingMachine vendingMachine, int slotId) {
        if(!vendingMachine.getInventory().isAvailable(slotId)) throw new RuntimeException("The item is not available!");
        vendingMachine.setSelectedSlot(slotId);
        vendingMachine.setState(new ReadyState());
    }

    @Override
    public void makePayment(VendingMachine vendingMachine, PaymentMethod paymentMethod) {
        throw new RuntimeException("Select slot first");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        throw new RuntimeException("No slot has been selected");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        throw new RuntimeException("No slot has been selected");
    }
}
