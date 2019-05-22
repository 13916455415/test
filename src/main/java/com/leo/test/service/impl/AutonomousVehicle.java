package com.leo.test.service.impl;

import com.leo.test.Exceptions.MoveOutOfBoundsException;
import com.leo.test.Utils.OrientationUtils;
import com.leo.test.model.Orientation;
import com.leo.test.model.Park;
import com.leo.test.service.Car;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class AutonomousVehicle implements Car {
    private int positionX;
    private int positionY;
    private Orientation orientation;
    public static AutonomousVehicle instance;
    public static Park park = Park.getInstance();

    public static synchronized AutonomousVehicle getInstance(){
        if (null==instance){
            Random random = new Random();
            Orientation currentOrientation = OrientationUtils.getRandomOrientation();
            int positionX = random.nextInt(park.getLength() - 1) + 1;
            int positionY = random.nextInt(park.getWidth() - 1) + 1;
            //Initialize an autonomous vehicle,xy coordinate is the non-boundary random position in the parking lot, direction is east, south, west, north, one random direction
            instance = new AutonomousVehicle(positionX, positionY, currentOrientation);
            log.info("初始化一辆自动驾驶汽车,坐标为: x=" + positionX + " , y=" + positionY + " ,汽车朝向为 : " + currentOrientation.toString());
        }
        return instance;
    }


    public AutonomousVehicle(int positionX, int positionY, Orientation orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "AutonomousVehicle{" +
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

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void move(AutonomousVehicle car, Orientation orientation) {
        //get the random clockwise direction
        orientation = OrientationUtils.getRandomClockwiseOrientation(orientation);
        Park park = Park.getInstance();
        int positionX = car.getPositionX();
        int positionY = car.getPositionY();
        switch (orientation) {
            //if the car  goes one unit north, then the y-coordinate is plus 1
            case NORTH:
                positionY++;
                break;
            //if the car goes one unit south, then the x-coordinate is plus 1
            case EAST:
                positionX++;
                break;
                //if the car goes one unit south, then the y-coordinate is negative 1
            case SOUTH:
                positionY--;
                break;
                //if the car goes one unit to the west, then the x-coordinate is negative 1
            case WEST:
                positionX--;
                break;
            default:
                break;
        }
        //Determine whether the car will drive to the boundary. Note that the setting here is that the length of the parking lot corresponds to the X-axis direction and the width of the parking lot corresponds to the Y-axis direction
        if (positionX==0||positionX==park.getLength()||positionY==0||positionY==park.getWidth()){
            car.setOrientation(orientation);
            throw new MoveOutOfBoundsException();
        }else {
            car.setPositionX(positionX);
            car.setPositionY(positionY);
            car.setOrientation(orientation);
        }

    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }
}
