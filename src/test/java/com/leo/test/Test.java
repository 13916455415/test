package com.leo.test;

import com.leo.test.Utils.RandomUtils;
import com.leo.test.model.Park;
import com.leo.test.service.Car;
import com.leo.test.service.impl.AutonomousVehicles;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        //初始化停车场,停车场长宽不小于3,长宽都是3-10随机长度
        for (int i = 0 ; i<20 ; i++){
            Park park = new Park(random.nextInt(7)+3,random.nextInt(7)+3);
            //初始化一辆自动驾驶汽车,xy坐标是在停车场内非边界随机位置,方向是东南西北随机一个方向
            Car car = new AutonomousVehicles(random.nextInt(park.getLength()-1)+1,random.nextInt(park.getWidth()-1)+1,RandomUtils.getRandomOrientation());
            System.out.println(park.toString());
            System.out.println(car.toString());
        }

    }
}
