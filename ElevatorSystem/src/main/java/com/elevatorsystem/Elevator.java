package com.elevatorsystem;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    private final int id;

    private final Queue<Integer> requests;

    private final ElevatorStatus elevatorStatus;

    public Elevator() {
        //potential ID collision
        this.id = (int) (Math.random() * 10000);
        this.requests = new LinkedList<>();
        this.elevatorStatus = new ElevatorStatus(0, Direction.IDLE);
    }

    public void addRequest(int floor) {
        requests.add(floor);
    }

    public void step() {
        //steps:
        // dequeue for next request
        //resolve next to determine direction of request
        //service request
        if (requests.isEmpty()) {
            this.elevatorStatus.setDirection(Direction.IDLE);
            return;
        }

        Integer nextFloor = requests.poll();
        Direction direction = nextFloor < this.elevatorStatus.getCurrentFloor() ? Direction.DOWN : Direction.UP;
        this.elevatorStatus.setDirection(direction);
        this.elevatorStatus.setCurrentFloor(nextFloor);

    }

    public ElevatorStatus getStatus() {
        return this.elevatorStatus;
    }

    public int getId() {
        return id;
    }
}