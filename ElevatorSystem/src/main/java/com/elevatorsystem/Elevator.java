package com.elevatorsystem;

import java.util.ArrayDeque;
import java.util.Queue;

public class Elevator {
    private final int id;

    private final Queue<Floor> requests;

    private boolean isIdle;

    private Floor currentFloor;

    private ElevatorDirection direction;

    public Elevator(int id) {
        this.id = id;
        this.requests = new ArrayDeque<>();
        this.currentFloor = Floor.create(0);
        this.isIdle = true;
        this.direction = ElevatorDirection.MOVING_UP;
    }

    public void addRequest(Floor floor) {
        requests.add(floor);
    }

    public void step() {

        if (requests.isEmpty()) {
            this.isIdle = true;
            return;
        }

//        this.isIdle = false;
//        Floor nextFloor = requests.poll();
//        this.direction = nextFloor.compareTo(this.currentFloor) < 0
//                ? ElevatorDirection.MOVING_DOWN : ElevatorDirection.MOVING_UP;
//        this.currentFloor = nextFloor;
    }

    public int getId() {
        return id;
    }
}