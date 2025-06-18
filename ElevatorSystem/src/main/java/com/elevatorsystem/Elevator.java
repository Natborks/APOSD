package com.elevatorsystem;

/**
 * A representation of the essential functions an elevator should possess.
 */
public interface Elevator {

    /**
     * Moves the elevator to the intended destination of the pickup request.
     *
     * @param floor the intended destination of the pickup request
     */
    void service(Floor floor);

    /***
     * Provides information on the current level of the elevator.
     *
     * @return the current floor where the elevator is located
     */
    Floor getCurrentFloor();
}
