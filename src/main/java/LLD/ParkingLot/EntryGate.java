package main.java.LLD.ParkingLot;

public class EntryGate {
    private final ParkingLot parkingLot;
    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    public Ticket park(Vehicle vehicle) {
        return parkingLot.park(vehicle);
    }
}
