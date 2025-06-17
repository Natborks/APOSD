package com.elevatorsystem;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableSet;

public class FloorDomain {

    public static DiscreteDomain<Integer> create (ImmutableSet<Integer> invalidLevels) {
        return DiscreteDomain.integers();
    }


}
