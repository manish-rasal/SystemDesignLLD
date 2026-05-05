package main.java.LLD.ParkingLot;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class ParkingLot {
    private HashMap<Integer, ParkingFloor> parkingFloors;

    public ParkingLot(HashMap<Integer, ParkingFloor> floors) {
        this.parkingFloors = floors;
    }

    public Ticket park(Vehicle vehicle) {
        for(ParkingFloor floor: parkingFloors.values()) {
            ParkingSpot spot = floor.assignSpot(vehicle);
            if(spot != null) {
                spot.park(vehicle);
                return new Ticket(spot, floor.getLevel());
            }
        }

        throw new RuntimeException("Parking full!");
    }

    public void releaseSpot(Ticket ticket) {
        int level = ticket.getFloor();
        ParkingSpot spot = ticket.getSpot();
        spot.freeSpot();
        parkingFloors.get(level).releaseSpot(spot);
    }

    public double calculateFees(Ticket ticket) {
        Instant now = Instant.now();
        long hours = Math.max(
                1,
                Duration.between(
                        ticket.getEntryTime(),
                        now
                ).toHours()
        );

        return hours * 20;
    }
}
