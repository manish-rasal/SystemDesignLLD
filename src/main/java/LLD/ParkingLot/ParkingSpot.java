package main.java.LLD.ParkingLot;

public class ParkingSpot {
    private final int id;
    private final SpotType type;

    private Vehicle vehicle;

    public ParkingSpot(int id, SpotType type) {
        this.id = id;
        this.type = type;
    }

    public void freeSpot() {
        vehicle = null;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SpotType getType() {
        return type;
    }
}
