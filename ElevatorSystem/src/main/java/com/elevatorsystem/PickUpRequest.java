package com.elevatorsystem;


import static com.elevatorsystem.ElevatorDirection.*;

public record PickUpRequest (
        Floor pickUpFloor,

        ElevatorDirection direction,

        RequestType requestType) {

    public static PickUpRequest up (Floor pickUpFloor) {
        return new PickUpRequest( pickUpFloor,
                ELEVATOR_DIRECTION_UP,
                RequestType.REGULAR_REQUEST
        );
    }

    public static PickUpRequest down(Floor pickUpFloor) {
        return new PickUpRequest(
                pickUpFloor,
                ELEVATOR_DIRECTION_DOWN,
                RequestType.REGULAR_REQUEST
        );
    }
}
