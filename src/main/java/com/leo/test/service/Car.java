package com.leo.test.service;

import com.leo.test.model.Orientation;
import com.leo.test.service.impl.AutonomousVehicle;

public interface Car {
    void move(AutonomousVehicle car ,Orientation orientation);
    int getPositionX();
    int getPositionY();
    Orientation getOrientation();
}
