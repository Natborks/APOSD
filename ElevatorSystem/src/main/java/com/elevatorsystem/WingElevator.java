package com.elevatorsystem;

public class WingElevator implements Elevator{
    private final int id;

    private Floor currentFloor;

    public WingElevator(int id) {
        this.id = id;
        this.currentFloor = Floor.create(0);
    }
    @Override
    public void service(Floor floor) {
        System.out.println("Elevator " + this.id +  " is servicing pickup request at: "
                + floor.number());
    }

    @Override
    public Floor getCurrentFloor() {
        return this.currentFloor;
    }


}