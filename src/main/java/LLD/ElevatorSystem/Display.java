package main.java.LLD.ElevatorSystem;

public class Display {
    int currentFloor;
    Direction direction;

    public void update(int floor, Direction direction) {
        this.currentFloor = floor;
        this.direction = direction;
        System.out.println("Display -> Floor: " + currentFloor + " Direction: " + direction);
    }
}
