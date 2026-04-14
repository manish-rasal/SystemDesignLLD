package main.java.LLD.ParkingLot;

import java.time.Instant;
import java.util.UUID;

public class Ticket {
    private final String  id;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final Instant entryTime;
    private TicketStatus status;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.vehicle = vehicle;
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
}
