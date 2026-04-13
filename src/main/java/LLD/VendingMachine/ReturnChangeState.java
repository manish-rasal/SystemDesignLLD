package main.java.LLD.VendingMachine;

public class ReturnChangeState implements State{
    @Override
    public void selectItem(VendingMachine vendingMachine, int slotId) {

    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) {

    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {

    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        int change = vendingMachine.getChange();
        System.out.println("Change returned: " + change);
        vendingMachine.resetTransaction();
        vendingMachine.setState(new IdleState());
    }
}
