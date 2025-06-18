package com.elevatorsystem;

/**
 *  This class represents an elevator in the wings of a building
 */
public class WingElevator implements Elevator{
    private final int id;

    private final Floor currentFloor;

    /**
     * The constructor for an elevator that exists within the wings of building
     *
     * @param id the unique identifier for the elevator;
     */

    public WingElevator(int id) {
        this.id = id;
        this.currentFloor = Floor.create(0);
    }

    /**
     * Moves the elevator to the intended destination of the pickup request and
     *
     * @param floor the intended destination of the pickup request
     */
    @Override
    public void service(Floor floor) {

    }

    /***
     * provides information on the current level of the elevator
     *
     * @return the current floor where the elevator is located
     */
    @Override
    public Floor getCurrentFloor() {
        return this.currentFloor;
    }


}