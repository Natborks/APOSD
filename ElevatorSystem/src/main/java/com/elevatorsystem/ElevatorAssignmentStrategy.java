package com.elevatorsystem;

import java.util.List;

public interface ElevatorAssignmentStrategy {
    Elevator assignElevator(List<Elevator> elevators, PickUpRequest pickUpRequest);
}