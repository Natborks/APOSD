package com.elevatorsystem;

public interface Elevator {

    void service(Floor pickUpRequest);

    Floor getCurrentFloor();
}
