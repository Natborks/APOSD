package com.elevatorsystem;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.elevatorsystem.ElevatorDirection.*;
public class ElevatorSystem {

    public static final int BUFFER_SIZE =100;
    private final ElevatorAssignmentStrategy assignmentStrategy;

    private final List<Elevator> elevators;

    private final BuildingConfig buildingConfig;

    private final BlockingQueue<PickUpRequest> requests;

    private final Scanner scanner;


    public ElevatorSystem(int numElevators,
                          ElevatorAssignmentStrategy strategy,
                          BuildingConfig buildingConfig
    ) {
        this.assignmentStrategy = strategy;
        this.buildingConfig = buildingConfig;
        this.requests = new ArrayBlockingQueue<>(BUFFER_SIZE);

        this.elevators = new ArrayList<>(numElevators);
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new WingElevator(i);
            this.elevators.add(elevator);
        }

        this.scanner = new Scanner(System.in);
    }


    public void pickUpRequest(PickUpRequest pickUpRequest) {
        if (!buildingConfig.getValidLevels().contains(pickUpRequest.pickUpFloor().number())) {
            //set floor to closest floor number
            return;
        }

        try {
            this.requests.put(pickUpRequest);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void serviceRequests() {
        while (true) {
            try {
                PickUpRequest pickUpRequest = requests.take();

                Elevator elevator = assignmentStrategy.assignElevator(this.elevators, pickUpRequest);
                elevator.service(pickUpRequest.pickUpFloor());

                System.out.print("Enter Destination floor: ");
                String input = scanner.nextLine();

                elevator.service(Floor.create(Integer.parseInt(input)));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void makeRequest() {
        while (true) {
            System.out.println("Going UP/DOWN? Enter 1 for UP and 0 for DOWN: ");
            int dirInput = Integer.parseInt(scanner.nextLine());
            ElevatorDirection direction = (dirInput == 1) ? ELEVATOR_DIRECTION_UP : ELEVATOR_DIRECTION_DOWN;

            System.out.println("Enter floor number to request pickup from: ");
            int floorNumber = Integer.parseInt(scanner.nextLine());
            Floor pickUpFloor = Floor.create(floorNumber);

            try {
                requests.put(PickUpRequest.up(pickUpFloor));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}

