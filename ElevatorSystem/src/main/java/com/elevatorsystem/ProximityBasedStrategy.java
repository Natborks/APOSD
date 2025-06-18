package com.elevatorsystem;

import java.util.List;

/**
 * An implementation of the pickup strategy where available elevators are chosen basen their
 * closeness to the elevator request.
 */
public class ProximityBasedStrategy implements ElevatorAssignmentStrategy {

    /***
     * Assigns an appropriate elevator from the list of available elevators based on their proximity
     * to the pickup request.
     *
     * @param elevators the available elevators in the building
     * @param pickUpRequest a request for an elevator pickup container the floor and direction
     * @return the closest elevator to the pickup request
     */
    @Override
    public Elevator assignElevator(List<Elevator> elevators, PickUpRequest pickUpRequest) {
        Elevator closestElevator = null;

        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator :
                elevators) {
            int distance = Math.abs(pickUpRequest.pickUpFloor().number() - elevator.getCurrentFloor().number());
            if (distance < minDistance) {
                minDistance = distance;
                closestElevator = elevator;
            }
        }
        return closestElevator;
    }
}