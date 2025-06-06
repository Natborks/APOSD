package com.elevatorsystem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static final int INITIAL_ELEVATOR_COUNT = 2;

    public static void main(String[] args) {
        ElevatorAssignmentStrategy elevatorAssignmentStrategy = new ProximityBasedStrategy();
        Set<Integer> invalidLevels = new HashSet<>();
        invalidLevels.add(13);
        BuildingConfig buildingConfig = new BuildingConfig(invalidLevels, 10, 0);
        ElevatorSystem elevatorSystem = new ElevatorSystem(
                INITIAL_ELEVATOR_COUNT,
                elevatorAssignmentStrategy,
                buildingConfig
        );

        Thread elevatorSystemThread = new Thread(elevatorSystem::run);
        elevatorSystemThread.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Going UP/DOWN? Enter 1 for UP and 0 for DOWN: ");
            int dirInput = Integer.parseInt(scanner.nextLine());
            ElevatorDirection direction = (dirInput == 1) ? ElevatorDirection.MOVING_UP
                    : ElevatorDirection.MOVING_DOWN;

            //In a real system, the floor will be known
            System.out.print("Enter floor number to request pickup from: ");
            int floorNumber = Integer.parseInt(scanner.nextLine());
            Floor pickUpFloor = Floor.create(floorNumber);

            PickUpRequest pickUpRequest = new PickUpRequest(
                    pickUpFloor,
                    direction,
                    RequestType.REGULAR_REQUEST
            );

            try {
                elevatorSystem.requestPickup(pickUpRequest);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}



