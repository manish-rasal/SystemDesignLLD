package main.java.LLD.EnhancedVendingMachine;

public class CoinPayment implements PaymentMethod{

    private int amount;

    @Override
    public int pay() {
        return amount;
    }

    @Override
    public void refund(int amount) {
        System.out.println("Amount: " + amount + " has been returned");
    }

    public CoinPayment(Coin coin) {
        this.amount += coin.getValue();
    }
}
