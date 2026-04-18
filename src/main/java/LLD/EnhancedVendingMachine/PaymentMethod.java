package main.java.LLD.EnhancedVendingMachine;

public interface PaymentMethod {
    int pay();
    void refund(int amount);
}
