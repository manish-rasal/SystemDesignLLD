package main.java.LLD.ElevatorSystem;

public class Door {
    boolean open = false;

    public void openDoor() {
        System.out.println("Door Opening");
        open = true;
    }

    public void closeDoor() {
        System.out.println("Door closing");
        open = false;
    }
}
