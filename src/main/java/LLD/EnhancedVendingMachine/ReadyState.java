package main.java.LLD.EnhancedVendingMachine;

public class ReadyState implements State{
    @Override
    public void selectSlot(VendingMachine vendingMachine, int slotId) {
        throw new RuntimeException("The item is already selected");
    }

    @Override
    public void makePayment(VendingMachine vendingMachine, PaymentMethod paymentMethod) {
        vendingMachine.setPaymentMethod(paymentMethod);
        vendingMachine.addBalance();
        if(vendingMachine.hasSufficientBalance()) {
            vendingMachine.setState(new DispenseState());
        }
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        throw new RuntimeException("Make the payment first");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {

    }
}
