package main.java.LLD.ParkingLot;

public class ParkingSpot {
    private final int id;
    private final SpotType type;

    private Vehicle vehicle;

    public ParkingSpot(int id, SpotType type) {
        this.id = id;
        this.type = type;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void freeSpot() {
        vehicle = null;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public SpotType getType() {
        return type;
    }
}
