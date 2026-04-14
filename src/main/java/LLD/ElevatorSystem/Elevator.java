package main.java.LLD.ElevatorSystem;

import java.util.TreeSet;

public class Elevator {
    final int id;
    int currentFloor;
    Status status;
    Direction direction;

    TreeSet<Integer> upStops;
    TreeSet<Integer> downStops;

    Door door;
    Display display;

    public Elevator(int id) {
        this.id = id;
        currentFloor = 0;
        status = Status.IDLE;
        direction = Direction.IDLE;

        upStops = new TreeSet<>();
        downStops = new TreeSet<>();

        door = new Door();
        display = new Display();
    }

    public void addStop(int floor) {
        if(floor == currentFloor) return;
        else if(floor > currentFloor) {
            upStops.add(floor);
        } else {
            downStops.add(floor);
        }
    }

    public boolean hasPendingStops() {
        return !upStops.isEmpty() || !downStops.isEmpty();
    }

    public Integer getNextStop() {
        if(direction == Direction.UP) {
            if(!upStops.isEmpty()) {
                return upStops.first();
            }
            direction = Direction.DOWN;
            if(!downStops.isEmpty()) {
                return downStops.last();
            }
        } else if (direction == Direction.DOWN) {
            if(!downStops.isEmpty()) return downStops.last();
            direction = Direction.UP;
            if(!upStops.isEmpty()) return upStops.first();
        } else {
            if(!upStops.isEmpty()) {
                direction = Direction.UP;
                return upStops.first();
            }
            if(!downStops.isEmpty()) {
                direction = Direction.DOWN;
                return downStops.last();
            }
        }
        direction = Direction.IDLE;
        return null;
    }

    public void removeStop(int floor) {
        upStops.remove(floor);
        downStops.remove(floor);
    }
}
