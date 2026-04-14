package main.java.LLD.ElevatorSystem;

public class ElevatorController {
    Elevator elevator;

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    public synchronized void submitRequest(int floor) {
        elevator.addStop(floor);
        if(floor > elevator.currentFloor) {
            elevator.direction = Direction.UP;
        } else {
            elevator.direction = Direction.DOWN;
        }
    }

    public synchronized void move() {
        while(elevator.hasPendingStops()) {
            Integer next = elevator.getNextStop();

            if(next == null) break;

            travelTo(next);
        }
        elevator.status = Status.IDLE;
        elevator.direction = Direction.IDLE;
    }

    private void travelTo(int floor) {
        elevator.status = Status.MOVING;
        elevator.currentFloor = floor;

        System.out.println("Elevator: " + elevator.id);
        elevator.display.update(elevator.currentFloor, elevator.direction);

        elevator.door.openDoor();
        elevator.removeStop(floor);
        elevator.door.closeDoor();
        elevator.status = Status.IDLE;
    }
}
