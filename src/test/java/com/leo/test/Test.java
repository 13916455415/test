package com.leo.test;

import com.leo.test.Exceptions.MoveOutOfBoundsException;
import com.leo.test.Utils.OrientationUtils;
import com.leo.test.model.Orientation;
import com.leo.test.model.Park;
import com.leo.test.service.impl.AutonomousVehicle;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
public class Test {
    public static void main(String[] args) throws InterruptedException {
        AutonomousVehicle car = AutonomousVehicle.getInstance();
        //标记开始行驶时间
        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < 200; i++) {
            Duration duration = java.time.Duration.between(start,  LocalDateTime.now() );
            //如果行驶超过4小时,则休息半小时
            if (duration.toHours()>=4){
                log.warn("自动驾驶超过4小时,休眠半小时");
                Thread.sleep(1800000l);
            }
            log.info("第"+i+"次行驶前汽车位置 : x" + car.getPositionX() + " , y = "+car.getPositionY()+ " ,汽车朝向为 : " + car.getOrientation().toString());
            try {
                car.move(car, car.getOrientation());
                log.info("第"+i+"次行驶后汽车位置 : x = " + car.getPositionX() + " , y = "+car.getPositionY()+ " ,汽车朝向为 : " + car.getOrientation().toString());
                Thread.sleep(200l);
            } catch (MoveOutOfBoundsException e) {
                log.warn("警告,汽车预计将行驶至于停车场边界,将重新生成路线");
                continue;
            }
        }
    }
}
