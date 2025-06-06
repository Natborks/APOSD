package com.elevatorsystem;

public record PickUpRequest (
        Floor pickUpFloor,

        ElevatorDirection direction,

        RequestType requestType) {

}
