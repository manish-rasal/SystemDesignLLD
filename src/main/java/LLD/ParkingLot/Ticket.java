package main.java.LLD.ParkingLot;

import java.time.Instant;
import java.util.UUID;

public class Ticket {
    private final String  id;
    private final ParkingSpot spot;
    private final Instant entryTime;
    private final int floor;
    private TicketStatus status;

    public Ticket(ParkingSpot spot, int floor) {
        this.floor = floor;
        this.spot = spot;
        this.id = UUID.randomUUID().toString();
        this.entryTime = Instant.now();
        this.status = TicketStatus.ACTIVE;
    }

    public void markPaid() {
        this.status = TicketStatus.PAID;
    }

    public ParkingSpot getSpot() {
        return this.spot;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public int getFloor() {
        return floor;
    }
}
