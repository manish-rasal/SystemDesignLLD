package main.java.LLD.ParkingLot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ParkingFloor {
    private final int level;
    private HashMap<SpotType, Queue<ParkingSpot>> availableSpots;

    public ParkingFloor(int level) {
        this.level = level;
        availableSpots = new HashMap<>();
        for(SpotType spot: SpotType.values()) {
            availableSpots.put(spot, new LinkedList<>());
        }
    }

    public void addSpot(ParkingSpot spot) {
        availableSpots.get(spot.getType()).add(spot);
    }

    public ParkingSpot assignSpot(Vehicle vehicle) {
        SpotType compatible = switch (vehicle.getType()) {
            case BIKE -> SpotType.SMALL;
            case CAR -> SpotType.MEDIUM;
            case TRUCK -> SpotType.LARGE;
        };

        Queue<ParkingSpot> available = availableSpots.get(compatible);
        if(!available.isEmpty()) return available.poll();
        return null;
    }

    public void releaseSpot(ParkingSpot parkingSpot) {
        availableSpots.get(parkingSpot.getType()).add(parkingSpot);
    }
}
