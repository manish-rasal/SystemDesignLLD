package main.java.LLD.VendingMachine;

public class Slot {
    private final Item item;
    private int quantity;

    public Slot(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity >= 1;
    }

    public void dispense() {
        if (quantity == 0) throw new RuntimeException("Out of stock");
        quantity--;
    }

    public Item getItem() {
        return item;
    }
}
