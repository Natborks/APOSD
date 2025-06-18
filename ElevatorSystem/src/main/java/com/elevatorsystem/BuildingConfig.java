package com.elevatorsystem;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;

/***
 * A building configuration to keep track of floors  in a building
 */
public class BuildingConfig {

    private final Range<Integer> validFloors;

    /***
     * This constructor initializes the valid levels in a building by creating a range of floors
     * that are accessible by an elevator and omitting the ones that inaccessible
     *
     * @param invalidLevels the invalid levels that an elevator cannot move to
     * @param highestFloor the highest floor accessible by an elevator
     * @param lowestFloor the lowest floor accessible by an elevator
     */
    public BuildingConfig(ImmutableSet<Integer> invalidLevels, int highestFloor, int lowestFloor) {

        this.validFloors =  Range.closed(lowestFloor, highestFloor)
                .canonical(FloorDomain.create(invalidLevels));
    }

    /**
     * This method  returns the range of valid floors that an elevator can go to in a building
     *
     * @return a range of valid floors that an elevator can go to within a building
     */
    public Range<Integer> getValidFloors() {
        return validFloors;
    }
}
