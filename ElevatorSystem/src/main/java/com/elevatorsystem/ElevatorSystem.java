package com.elevatorsystem;

import java.util.*;

public class ElevatorSystem {

    private final ElevatorAssignmentStrategy assignmentStrategy;

    private final List<Elevator> elevators;

    public ElevatorSystem(int numElevators, ElevatorAssignmentStrategy strategy) {
        this.assignmentStrategy = strategy;

        this.elevators = new ArrayList<>(numElevators);
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new Elevator(i);
            this.elevators.add(elevator);        }
    }

    public void requestPickup(Floor pickUpFloor, Floor destinationFloor) {
        Elevator elevator = assignmentStrategy.assignElevator(this.elevators, pickUpFloor);
        elevator.addRequest(destinationFloor);
    }

    public void getElevatorStatus() {

        for (Elevator elevator : this.elevators) {
            System.out.println("Elevator " + elevator.getId());
        }
    }
}