package main.java.LLD.VendingMachine;

import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Slot> slots;

    public Inventory() {
        slots = new HashMap<>();
    }

    public boolean isAvailable(int slotId) {
        return slots.get(slotId).isAvailable();
    }

    public void addSlot(int id, Slot slot) {
        slots.put(id, slot);
    }

    public Item getItem(int slotId) {
        return slots.get(slotId).getItem();
    }

    public void dispense(int slotId) {
        slots.get(slotId).dispense();
    }
}
