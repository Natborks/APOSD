package com.elevatorsystem;


import static com.elevatorsystem.ElevatorDirection.*;

/**
 * Represents a request made from a floor to call an elevator.
 *
 * @param pickUpFloor the floor where a request for an elevator was used
 * @param direction the intended direction of the destinaton of the elevator
 * @param requestType an enum representing the different types of requests that can be made in an elevator system
 */
public record PickUpRequest (
        Floor pickUpFloor,

        ElevatorDirection direction,

        RequestType requestType) {

    /**
     * Creates a pickup request to upwards from a given floor.
     *
     * @param pickUpFloor the floor where the request was made
     * @return an instance of a pickup request for  going  upwards
     */
    public static PickUpRequest up (Floor pickUpFloor) {
        return new PickUpRequest( pickUpFloor,
                ELEVATOR_DIRECTION_UP,
                RequestType.REGULAR_REQUEST
        );
    }

    /**
     * Creates a pickup request to go downwards from the given floor.
     *
     * @param pickUpFloor the floor where the request was made
     * @return an instance of a Pickup request for going downwards
     */
    public static PickUpRequest down(Floor pickUpFloor) {
        return new PickUpRequest(
                pickUpFloor,
                ELEVATOR_DIRECTION_DOWN,
                RequestType.REGULAR_REQUEST
        );
    }
}
