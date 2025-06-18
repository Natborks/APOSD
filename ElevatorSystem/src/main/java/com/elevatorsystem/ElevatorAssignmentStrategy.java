package com.elevatorsystem;

import java.util.List;

/**
 * An abstract representation of the strategy for assigning elevators to pickup requests
 */
public interface ElevatorAssignmentStrategy {

    /**
     * Assigns an appropriate elevator from the list of available elevators based on the given pickup request.
     *
     * Implementations of this method should determine the most suitable elevator to handle
     * the pickup request, potentially considering factors such as current direction
     *
     * @param elevators the list of all available elevators in the system
     * @param pickUpRequest the pickup request containing floor and direction information
     * @return the elevator selected to service the pickup request
     */
    Elevator assignElevator(List<Elevator> elevators, PickUpRequest pickUpRequest);
}