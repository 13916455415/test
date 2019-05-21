package com.leo.test.Utils;

import com.leo.test.model.Orientation;

import java.util.Random;

public class RandomUtils {

    public static String getRandomOrientation(){
        try {
            Orientation[] orientations = Orientation.values();
            Random random = new Random();
            Orientation orientation = orientations[random.nextInt(orientations.length)];
            return orientation.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
            return null;
    }
}
