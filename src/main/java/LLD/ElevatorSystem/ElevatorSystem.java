package main.java.LLD.ElevatorSystem;

import java.util.List;

class ElevatorSystem {

    private final Scheduler scheduler;

    public ElevatorSystem(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void handleExternalRequest(Request request) {

        ElevatorController controller =
                scheduler.assignElevator(request);

        controller.submitRequest(request.getFloor());

        controller.move();
    }
}
