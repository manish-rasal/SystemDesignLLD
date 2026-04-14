package main.java.LLD.ParkingLot;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(List<ParkingFloor> floors) {
        this.parkingFloors = floors;
    }

    public Ticket park(Vehicle vehicle) {
        for(ParkingFloor floor: parkingFloors) {
            ParkingSpot spot = floor.assignSpot(vehicle);
            if(spot != null) {
                spot.park(vehicle);
                return new Ticket(vehicle, spot);
            }
        }

        throw new RuntimeException("Parking full!");
    }

    public void releaseSpot(Ticket ticket) {
        ParkingSpot spot = ticket.getSpot();
        spot.freeSpot();
        for(ParkingFloor floor: parkingFloors) {
            floor.releaseSpot(spot);
        }
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
