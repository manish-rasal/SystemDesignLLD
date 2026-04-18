package main.java.LLD.EnhancedVendingMachine;

public class DispenseState implements State{
    @Override
    public void selectSlot(VendingMachine vendingMachine, int slotId) {
        throw new RuntimeException("Item is getting dispensed");
    }

    @Override
    public void makePayment(VendingMachine vendingMachine, PaymentMethod paymentMethod) {
        throw new RuntimeException("Item is getting dispensed");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        vendingMachine.getInventory().dispense(vendingMachine.getSelectedSlot());
        System.out.println("The item: " + vendingMachine.getInventory().getItem(vendingMachine.getSelectedSlot()).getName() + " has been dispensed");
        vendingMachine.setState(new ReturnChangeState());
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {

    }
}
