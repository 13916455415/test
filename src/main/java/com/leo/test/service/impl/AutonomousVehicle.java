package com.leo.test.service.impl;

import com.leo.test.Exceptions.MoveOutOfBoundsException;
import com.leo.test.Utils.OrientationUtils;
import com.leo.test.model.Orientation;
import com.leo.test.model.Park;
import com.leo.test.service.Car;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutonomousVehicle implements Car {
    private int positionX;
    private int positionY;
    private Orientation orientation;

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
        //随机顺时针方向移动一个单位
        orientation = OrientationUtils.getRandomClockwiseOrientation(orientation);
        Park park = Park.getInstance();
        int positionX = car.getPositionX();
        int positionY = car.getPositionY();
        switch (orientation) {
            //如果是向北行驶一个单位,则Y坐标+1
            case NORTH:
                positionY++;
                break;
            //如果是向南行驶一个单位,则X坐标+1
            case EAST:
                positionX++;
                break;
                //如果是向南行驶一个单位,则Y坐标-1
            case SOUTH:
                positionY--;
                break;
                //如果是向西行驶一个单位,则X坐标-1
            case WEST:
                positionX--;
                break;
            default:
                break;
        }
        //判断汽车是否将行驶到边界,注意,这里设定是停车场的长对应X轴方向,停车场的宽对应Y轴方向
        if (positionX==0||positionX==park.getLength()||positionY==0||positionY==park.getWidth()){
            log.warn("警告,汽车预计将行驶至于停车场边界,将重新生成路线");
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
