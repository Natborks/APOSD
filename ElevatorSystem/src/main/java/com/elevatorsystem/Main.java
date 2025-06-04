package com.elevatorsystem;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static final int INITIAL_ELEVATOR_COUNT = 4;

    public static void main(String[] args) {
        ElevatorAssignmentStrategy elevatorAssignmentStrategy = new ProximityBasedStrategy();
        ElevatorSystem elevatorSystem = new ElevatorSystem(INITIAL_ELEVATOR_COUNT, elevatorAssignmentStrategy);
        Set<Integer> invalidLevels = new HashSet<>();
        invalidLevels.add(13);
        FloorFactory.initialize(new BuildingConfig(
               invalidLevels,
                0,
                10
        ));

        //significant congnitive load to create Floor value objects, but doing it this way to
        // make the system configurable on statup
        elevatorSystem.requestPickup(
                FloorFactory.getInstance().create(0),
                FloorFactory.getInstance().create(10)
        );

        elevatorSystem.getElevatorStatus();
    }
}



