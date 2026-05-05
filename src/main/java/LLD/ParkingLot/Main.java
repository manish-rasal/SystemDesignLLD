package main.java.LLD.ParkingLot;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingFloor floor = new ParkingFloor(1);

        floor.addSpot(
                new ParkingSpot(1, SpotType.MEDIUM)
        );

        HashMap<Integer, ParkingFloor> floors = new HashMap<>();
        floors.put(1, floor);

        ParkingLot lot =
                new ParkingLot(floors);

        EntryGate entryGate =
                new EntryGate(lot);

        ExitGate exitGate =
                new ExitGate(
                        lot,
                        new CashPayment()
                );

        Vehicle car = new Car("MH12AB1234");

        Ticket ticket =
                entryGate.park(car);

        exitGate.exitVehicle(ticket);
    }
}
