package main.java.LLD.ParkingLot;

class ExitGate {

    private final ParkingLot parkingLot;
    private final PaymentStrategy paymentStrategy;

    public ExitGate(
            ParkingLot parkingLot,
            PaymentStrategy paymentStrategy
    ) {
        this.parkingLot = parkingLot;
        this.paymentStrategy = paymentStrategy;
    }

    public void exitVehicle(Ticket ticket) {

        double amount =
                parkingLot.calculateFees(ticket);

        paymentStrategy.pay(amount);

        parkingLot.releaseSpot(ticket);

        ticket.markPaid();
    }
}
