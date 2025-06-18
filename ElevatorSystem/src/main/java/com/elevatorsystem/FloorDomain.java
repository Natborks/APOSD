package com.elevatorsystem;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableSet;

/**
 * This class represents creates a domain of valid floors within an elevator system
 */
public class FloorDomain {

    /**
     * Creates discrete domain represent the valid floor within the elevator system. Omits the invalid floor.
     *
     * @param invalidLevels invalid elevator floor to be excluded from the domain of valid elevator floors
     * @return a discrete doman of floor without any invalid level
     */
    public static DiscreteDomain<Integer> create (ImmutableSet<Integer> invalidLevels) {
        return DiscreteDomain.integers();
    }


}
