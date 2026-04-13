package main.java.LLD.VendingMachine;

public class ReadyState implements State{

    @Override
    public void selectItem(VendingMachine vendingMachine, int slotId) {
        throw new RuntimeException("Item is already selected");
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.addBalance(coin.getValue());
        if(vendingMachine.hasSufficientBalance()) {
            vendingMachine.setState(new DispenseState());
        }
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {

    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {

    }
}
