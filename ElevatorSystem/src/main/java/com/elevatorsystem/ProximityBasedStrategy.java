package com.elevatorsystem;

import java.util.List;

public class ProximityBasedStrategy implements ElevatorAssignmentStrategy {
    @Override
    public Elevator assignElevator(List<Elevator> elevators, int floor) {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator :
                elevators) {
            ElevatorStatus status = elevator.getStatus();
            int distance = Math.abs(floor - status.getCurrentFloor());
            if (distance < minDistance) {
                minDistance = distance;
                closestElevator = elevator;
            }
        }
        return closestElevator;
    }
}