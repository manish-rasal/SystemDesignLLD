package main.java.LLD.ParkingLot;

import java.util.*;

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
        List<SpotType> compatible = getCompatibleSpotTypes(vehicle);

        for (SpotType type: compatible) {
            Queue<ParkingSpot> available = availableSpots.get(type);
            if(!available.isEmpty()) return available.poll();
        }

        return null;
    }

    private List<SpotType> getCompatibleSpotTypes(Vehicle vehicle) {
        List<SpotType> compatible = switch (vehicle.getType()) {
            case BIKE -> Arrays.asList(SpotType.SMALL, SpotType.MEDIUM, SpotType.LARGE);
            case CAR -> Arrays.asList(SpotType.MEDIUM, SpotType.LARGE);
            case TRUCK -> Arrays.asList(SpotType.LARGE);
        };
        return compatible;
    }

    public void releaseSpot(ParkingSpot parkingSpot) {
        availableSpots.get(parkingSpot.getType()).add(parkingSpot);
    }

    public int getLevel() {
        return level;
    }
}
