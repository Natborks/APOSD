package com.elevatorsystem;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Floor {
    public abstract int number();

    public static Floor create(int number) {
        if (number < 1 || number > 100 || number == 13) {
            throw new IllegalArgumentException("Invalid floor number");
        }
        return new AutoValue_Floor(number);
    }

}
