package com.elevatorsystem;

public class ElevatorStatus {
    private int currentFloor;

    private Direction direction;

    public ElevatorStatus(int currentFloor, Direction direction) {
        this.currentFloor = currentFloor;
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
