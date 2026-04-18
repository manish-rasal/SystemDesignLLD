package main.java.LLD.EnhancedVendingMachine;

public class Slot {
    private Item item;
    private int quantity;
    public Slot(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity >= 1;
    }

    public void dispense() {
        if(quantity == 0) throw new RuntimeException("The selected item is out of stock!");
        quantity--;
    }

    public Item getItem() {
        return item;
    }
}
