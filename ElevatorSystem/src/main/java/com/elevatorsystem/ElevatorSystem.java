package com.elevatorsystem;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.elevatorsystem.ElevatorDirection.*;

/***
 * The elevator system or controller class to manage the operation of elevators
 * this class is responsible taking elevator requests and servicing them.
 */
public class ElevatorSystem {
    public static final int BUFFER_SIZE =100;
    private final ElevatorAssignmentStrategy assignmentStrategy;

    private final List<Elevator> elevators;

    private final BuildingConfig buildingConfig;

    private final BlockingQueue<PickUpRequest> requests;

    private final Scanner scanner;


    /***
     * This is the constructor for the elevator system that initializes the number and types of
     * elevators used in the building
     *
     * @param numElevators the number of elevators within this building
     * @param strategy the strategy used for dispatching an elevator for a request
     * @param buildingConfig the configuration of the building which can
     */
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
        if (!buildingConfig.getValidFloors().contains(pickUpRequest.pickUpFloor().number())) {
            //set floor to closest floor number
            return;
        }

        try {
            this.requests.put(pickUpRequest);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * This method ontinuously takes requests from the requests queue and dispatches them to available elevators.
     *
     * @precondition should run on a separate thread.
     */
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


    /***
     * Thjis method continuously creates a pickup request using direction and destination
     * floor and adds it to the requests queue
     *
     * @precondition should run on a sperate thread.
     *
     */
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

