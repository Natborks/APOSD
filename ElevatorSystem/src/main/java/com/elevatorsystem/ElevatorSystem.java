package com.elevatorsystem;

import java.util.*;

public class ElevatorSystem {

    final ElevatorAssignmentStrategy assignmentStrategy;

    final List<Elevator> elevators;

    public ElevatorSystem(int numElevators, ElevatorAssignmentStrategy strategy) {
        this.assignmentStrategy = strategy;

        //this can be moved to another method, but does making it obscure doesn't really provide any benefit?
        this.elevators = new ArrayList<>(numElevators);
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new Elevator();
            this.elevators.add(elevator);        }
    }

    public void requestPickup(int pickUpFloor, int destinationFloor) {
        Elevator elevator = assignmentStrategy.assignElevator(this.elevators, pickUpFloor);
        elevator.addRequest(destinationFloor);
    }

    public void step() {
        //looks like pass through method, but I feel it is unavoidable in this case.
        // given that there is still significant functionality provided by each elevator
        for (Elevator elevator : this.elevators) {
            elevator.step();
        }
    }

    public void getElevatorStatus() {

        for (Elevator elevator : this.elevators) {
            System.out.println("Elevator " + elevator.getId() + " is at "
                    + elevator.getStatus().getCurrentFloor());
        }
    }
}