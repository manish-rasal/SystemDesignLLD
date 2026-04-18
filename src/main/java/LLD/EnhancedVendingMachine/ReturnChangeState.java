package main.java.LLD.EnhancedVendingMachine;

public class ReturnChangeState implements State{
    @Override
    public void selectSlot(VendingMachine vendingMachine, int slotId) {

    }

    @Override
    public void makePayment(VendingMachine vendingMachine, PaymentMethod paymentMethod) {

    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {

    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        vendingMachine.refund(vendingMachine.getChange());
        vendingMachine.resetTransaction();
        vendingMachine.setState(new IdleState());
    }
}
