package main.java.LLD.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystemMain {
    public static void main(String[] args) {
        List<ElevatorController> controllers = new ArrayList<>();
        controllers.add(new ElevatorController(new Elevator(1)));
        controllers.add(new ElevatorController(new Elevator(2)));
        controllers.add(new ElevatorController(new Elevator(3)));
        Scheduler scheduler = new Scheduler(controllers);

        ElevatorSystem elevatorSystem = new ElevatorSystem(scheduler);

        elevatorSystem.handleExternalRequest(new Request(3, Direction.UP));
        elevatorSystem.handleExternalRequest(new Request(5, Direction.UP));
        elevatorSystem.handleExternalRequest(new Request(1, Direction.DOWN));
    }
}
