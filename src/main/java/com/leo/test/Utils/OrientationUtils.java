package com.leo.test.Utils;

import com.leo.test.model.Orientation;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
@Slf4j
public class OrientationUtils {
    static Random random = new Random();

    /**
     *Get random east, south, west, north, and south directions
     * @return
     */
    public static Orientation getRandomOrientation(){
        try {
            Orientation[] orientations = Orientation.values();

            Orientation orientation = orientations[random.nextInt(orientations.length)];
            return orientation;
        }catch (Exception e){
            e.printStackTrace();
        }
            return null;
    }

    /**
     * Randomly acquire clockwise turn or maintain current direction
     * @param currentOrientation
     * @return
     */
    public static Orientation getRandomClockwiseOrientation(Orientation currentOrientation){
        int i = random.nextInt(2);
        //maintain current direction
        if (1==i){
            log.info("The direction of the car is : "+currentOrientation.toString());
            return currentOrientation;
        }
        //or turn clockwise once
        else {
            currentOrientation = currentOrientation.NextClockwiseOrientation();
            log.info("The direction of the car is : "+currentOrientation.toString());
            return currentOrientation;
        }
    }


}
