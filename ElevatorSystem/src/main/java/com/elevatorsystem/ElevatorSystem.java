package com.elevatorsystem;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ElevatorSystem {

    private final ElevatorAssignmentStrategy assignmentStrategy;

    private final List<Elevator> elevators;

    private final BuildingConfig buildingConfig;

    private final BlockingQueue<PickUpRequest> requests;


    public ElevatorSystem(int numElevators,
                          ElevatorAssignmentStrategy strategy,
                          BuildingConfig buildingConfig
    ) {
        this.assignmentStrategy = strategy;
        this.buildingConfig = buildingConfig;
        this.requests = new ArrayBlockingQueue<>(100);

        this.elevators = new ArrayList<>(numElevators);
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new WingElevator(i);
            this.elevators.add(elevator);
        }
    }


    public void requestPickup(PickUpRequest pickUpRequest) throws InterruptedException {
        if (!buildingConfig.getValidLevels().contains(pickUpRequest.pickUpFloor().number())) {
            return;
        }

        this.requests.put(pickUpRequest);
    }

    public void run () {
        while (true) {
            serviceRequests();
        }
    }

    private void serviceRequests() {
        while (!requests.isEmpty()) {
            try {
                PickUpRequest pickUpRequest = this.requests.take();

                Elevator elevator = assignmentStrategy.assignElevator(this.elevators, pickUpRequest);

                elevator.service(pickUpRequest.pickUpFloor());

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter Destination floor: ");
                String input = scanner.nextLine();

                elevator.service(Floor.create(Integer.parseInt(input)));

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}