package com.leo.test;

import com.leo.test.Exceptions.MoveOutOfBoundsException;
import com.leo.test.service.impl.AutonomousVehicle;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
public class Test {
    /**
     * After the test starts, the parking lot will be initialized. The length and width of the parking lot shall not be less than 3,
     * and the length and width shall be 3-10 random lengths (the length and width of the parking lot shall not be less than 3).
     *
     * After initializing the parking lot, an autonomous vehicle will be initialized,xy coordinate is the non-boundary random position in the parking lot,
     * and the direction is east, south, west and north, one direction at random
     *
     * The car runs one unit at a time by default. Each time, it randomly decides whether to turn or maintain the current direction.
     *
     * When the car turns and runs, it will determine whether it will reach the boundary of the parking lot. If it will reach the boundary of the parking lot,
     * it will throw MoveOutOfBoundsException and calculate the driving route again until it is determined that it will not reach the boundary of the parking lot.
     *
     * After four hours of driving, the car will sleep for half an hour
     * @throws InterruptedException
     */
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
