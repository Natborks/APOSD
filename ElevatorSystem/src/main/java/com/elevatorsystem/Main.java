package com.elevatorsystem;

import com.google.common.collect.ImmutableSet;

import java.util.Scanner;

public class Main {
    public static final int INITIAL_ELEVATOR_COUNT = 2;

    public static void main(String[] args) {
        ElevatorAssignmentStrategy elevatorAssignmentStrategy = new ProximityBasedStrategy();
        ImmutableSet<Integer> invalidLevels = ImmutableSet.of(13);

        //config params should be specified in a file or via command line arguments
        BuildingConfig buildingConfig = new BuildingConfig(invalidLevels, 10, 0);

        ElevatorSystem elevatorSystem = new ElevatorSystem(
                INITIAL_ELEVATOR_COUNT,
                elevatorAssignmentStrategy,
                buildingConfig
        );
        Thread serviceRequestsThread = new Thread(elevatorSystem::serviceRequests);
        Thread createRequestsThread  = new Thread(elevatorSystem::makeRequest);
        serviceRequestsThread.start();
        createRequestsThread.start();

    }
}



