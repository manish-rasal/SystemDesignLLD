package main.java.LLD.ParkingLot;

public class CashPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs. " + amount + " is made through cash");
    }
}
