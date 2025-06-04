package com.elevatorsystem;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Floor {
    public abstract int number();

    public static Floor create(int number) {

        return new AutoValue_Floor(number);
    }

}
