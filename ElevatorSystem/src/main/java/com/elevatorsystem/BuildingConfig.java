package com.elevatorsystem;

import java.util.HashSet;
import java.util.Set;

public class BuildingConfig {

    private final Set<Integer> VALID_LEVELS;

    public BuildingConfig(Set<Integer> invalidLevels, int highest_floor, int lowest_floor) {

        final Set<Integer> validLevels = new HashSet<>();

        for (int i = lowest_floor; i <= highest_floor; i++) {
            if (invalidLevels.contains(i)) continue;

            validLevels.add(i);
        }

        this.VALID_LEVELS = validLevels;
    }

    public Set<Integer> getValidLevels() {
        return VALID_LEVELS;
    }
}
