package com.leo.test.model;

import com.leo.test.service.NextClockwiseOrientation;

public enum Orientation implements NextClockwiseOrientation {
    EAST(1),
    SOUTH(2),
    WEST(3),
    NORTH(0);
    private final int nextClockwiseOrientation;

     Orientation(final int nextClockwiseOrientation) {
        this.nextClockwiseOrientation = nextClockwiseOrientation;
    }
    @Override
    public Orientation NextClockwiseOrientation() {
            Orientation[] orientations = Orientation.values();
            Orientation orientation = orientations[nextClockwiseOrientation];
        return orientation;
    }
}
