package com.elevatorsystem;

public class FloorFactory {
    private static final FloorFactory instance = new FloorFactory();
    private boolean initialized = false;
    private BuildingConfig buildingConfig;

    public Floor create(int floorNumber) {
        if (!buildingConfig.getValidLevels().contains(floorNumber)) {
            throw new IllegalArgumentException("Invalid floor number: " + floorNumber);
        }
        return Floor.create(floorNumber);
    }

    private FloorFactory() {
        super();
    }

    public static void initialize(BuildingConfig buildingConfig) {
        if (instance.initialized) return;

        if (buildingConfig == null) {
            throw new IllegalArgumentException("BuildingConfig cannot be null.");
        }

        instance.buildingConfig = buildingConfig;
        instance.initialized = true;
    }

    public static FloorFactory getInstance() {
        if (!instance.initialized) throw new IllegalStateException("Floor Factory must be initialized before usage");

        return instance;
    }
}
