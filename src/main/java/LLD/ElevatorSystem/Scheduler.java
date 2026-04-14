package main.java.LLD.ElevatorSystem;

import java.util.List;

class Scheduler {

    private final List<ElevatorController> controllers;

    public Scheduler(List<ElevatorController> controllers) {
        this.controllers = controllers;
    }

    public ElevatorController assignElevator(Request request) {

        ElevatorController best = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController controller : controllers) {

            Elevator elevator =
                    controller.elevator;

            if (isSuitable(elevator, request)) {

                int distance =
                        Math.abs(
                                elevator.currentFloor
                                        - request.getFloor()
                        );

                if (distance < minDistance) {

                    minDistance = distance;
                    best = controller;
                }
            }
        }

        if (best == null)
            best = controllers.getFirst();

        return best;
    }

    private boolean isSuitable(
            Elevator elevator,
            Request request
    ) {

        if (elevator.direction == Direction.IDLE)
            return true;

        if (elevator.direction == request.getDirection()) {

            if (request.getDirection() == Direction.UP
                    && request.getFloor() >= elevator.currentFloor)
                return true;

            if (request.getDirection() == Direction.DOWN
                    && request.getFloor() <= elevator.currentFloor)
                return true;
        }

        return false;
    }
}