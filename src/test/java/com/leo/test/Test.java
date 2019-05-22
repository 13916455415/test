package com.leo.test;

import com.leo.test.Exceptions.MoveOutOfBoundsException;
import com.leo.test.Utils.OrientationUtils;
import com.leo.test.model.Orientation;
import com.leo.test.model.Park;
import com.leo.test.service.Car;
import com.leo.test.service.impl.AutonomousVehicle;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        //初始化停车场,停车场长宽不小于3,长宽都是3-10随机长度
        Park park = Park.getInstance();
        log.info("初始化停车场,长宽为 " + park.getLength() + "*" + park.getWidth());
        Orientation currentOrientation = OrientationUtils.getRandomOrientation();
        int positionX = random.nextInt(park.getLength() - 1) + 1;
        int positionY = random.nextInt(park.getWidth() - 1) + 1;
        //初始化一辆自动驾驶汽车,xy坐标是在停车场内非边界随机位置,方向是东南西北随机一个方向
        AutonomousVehicle car = new AutonomousVehicle(positionX, positionY, currentOrientation);
        log.info("初始化一辆自动驾驶汽车,坐标为: x=" + positionX + " , y=" + positionY + " ,汽车朝向为 : " + currentOrientation.toString());
        for (int i = 0; i < 20; i++) {
            log.info("行驶前汽车位置" + car.toString());
            try {
                car.move(car, currentOrientation);
            } catch (MoveOutOfBoundsException e) {
                e.printStackTrace();
            }
            log.info("行驶后汽车位置" + car.toString());
            Thread.sleep(4000l);
        }

    }
}
