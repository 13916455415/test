package com.leo.test.Utils;

import com.leo.test.model.Orientation;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
@Slf4j
public class OrientationUtils {
    static Random random = new Random();
    //获取随机东南西北方向
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
    //随机获取顺时针转向或者维持当前方向
    public static Orientation getRandomClockwiseOrientation(Orientation currentOrientation){
        int i = random.nextInt(2);
        //维持当前方向
        if (1==i){
            log.info("汽车将行驶方向为 : "+currentOrientation.toString());
            return currentOrientation;
        }
        //或者顺时针转向一次
        else {
            currentOrientation = currentOrientation.NextClockwiseOrientation();
            log.info("汽车将行驶方向为 : "+currentOrientation.toString());
            return currentOrientation;
        }
    }


}
