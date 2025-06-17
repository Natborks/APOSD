package com.elevatorsystem;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;

public class BuildingConfig {

    private final Range<Integer> validLevels;

    public BuildingConfig(ImmutableSet<Integer> invalidLevels, int highestFloor, int lowestFloor) {

        this.validLevels =  Range.closed(lowestFloor, highestFloor)
                .canonical(FloorDomain.create(invalidLevels));
    }

    public Range<Integer> getValidLevels() {
        return validLevels;
    }
}
