package com.leo.test.service.impl;

import com.leo.test.service.Car;

public class AutonomousVehicles implements Car {
    private int positionX;
    private int positionY;
    private String orientation;

    public AutonomousVehicles(int positionX,int positionY,String orientation){
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "AutonomousVehicles{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", orientation='" + orientation + '\'' +
                '}';
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    @Override
    public void move(String command) {

    }

    @Override
    public int getPositionX() {
        return 0;
    }

    @Override
    public int getPositionY() {
        return 0;
    }

    @Override
    public String getOrientation() {
        return null;
    }
}
