package com.elevatorsystem;

import com.google.auto.value.AutoValue;

/**
 * A value object to represent a floors in the elevator system.
 */
@AutoValue
public abstract class Floor {

    /***
     *
     * @return the integer representation of the floor class
     */
    public abstract int number();

    /***
     *
     * @param number the floor number that represent a given floor
     * @return an instance of the floor class. Uses auto value ...
     */
    public static Floor create(int number) {

        return new AutoValue_Floor(number);
    }

}
