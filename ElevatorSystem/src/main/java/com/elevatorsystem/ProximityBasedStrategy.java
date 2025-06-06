package com.elevatorsystem;

import java.util.List;

public class ProximityBasedStrategy implements ElevatorAssignmentStrategy {

    @Override
    public Elevator assignElevator(List<Elevator> elevators, PickUpRequest pickUpRequest) {
        Elevator closestElevator = null;

        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator :
                elevators) {
            int distance = Math.abs(pickUpRequest.pickUpFloor().number() - elevator.getCurrentFloor());
            if (distance < minDistance) {
                minDistance = distance;
                closestElevator = elevator;
            }
        }
        return closestElevator;
    }
}