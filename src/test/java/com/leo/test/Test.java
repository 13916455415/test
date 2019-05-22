package com.leo.test;

import com.leo.test.Exceptions.MoveOutOfBoundsException;
import com.leo.test.service.impl.AutonomousVehicle;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
public class Test {
    @org.junit.Test
    public  void test() throws InterruptedException {
        //initialize an autonomous vehicle
        AutonomousVehicle car = AutonomousVehicle.getInstance();
        //mark the start time
        LocalDateTime start = LocalDateTime.now();
        int i =1;
        while (true){
            Duration duration = java.time.Duration.between(start,  LocalDateTime.now() );
            //if the car drives more than 4 hours, rest for half an hour
            if (duration.toHours()>=4){
                log.warn("the car drives more than 4 hours, rest for half an hour");
                Thread.sleep(1800000l);
            }
            log.info("Travel times : "+i+" , Position of vehicle before driving : x = " + car.getPositionX() + " , y = "+car.getPositionY()+ " ,The direction of the car is : " + car.getOrientation().toString());
            try {
                car.move(car, car.getOrientation());
                log.info("Travel times : "+i+" ,Position of car after driving : x = " + car.getPositionX() + " , y = "+car.getPositionY()+ " ,The direction of the car is : " + car.getOrientation().toString());
                i++;
                //to make it easy to see the driving log, sleep for 1000 milliseconds after each drive is set
                Thread.sleep(1000l);
            } catch (MoveOutOfBoundsException e) {
                i++;
                log.warn("WARNING!!!,the car is expected to drive as far as the parking lot boundaries and will be rerouted");
                continue;
            }
        }
    }
}
