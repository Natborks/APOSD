package com.elevatorsystem;

public class Main {
    public static final int INITIAL_ELEVATOR_COUNT = 4;

    public static void main(String[] args) {
        ElevatorAssignmentStrategy elevatorAssignmentStrategy = new ProximityBasedStrategy();
        ElevatorSystem elevatorSystem = new ElevatorSystem(INITIAL_ELEVATOR_COUNT, elevatorAssignmentStrategy);

        elevatorSystem.requestPickup(0, 4);

        elevatorSystem.step();

        elevatorSystem.getElevatorStatus();
    }
}



