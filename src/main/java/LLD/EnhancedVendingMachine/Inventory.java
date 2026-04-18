package main.java.LLD.EnhancedVendingMachine;

import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Slot> slots;
    public Inventory() {
        slots = new HashMap<>();
    }

    public void addSlot(int slotId, Slot slot) {
        slots.put(slotId, slot);
    }

    public boolean isAvailable(int slotId) {
        return slots.get(slotId).isAvailable();
    }

    public void dispense(int slotId) {
        slots.get(slotId).dispense();
    }

    public Item getItem(int slotId) {
        return slots.get(slotId).getItem();
    }
}
