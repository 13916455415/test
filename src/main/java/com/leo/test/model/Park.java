package com.leo.test.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
@Slf4j
public class Park {
    private int length;
    private int width;
    public static Park instance;
    public Park(int length,int width){
        this.length=length;
        this.width=width;
    }

    public static synchronized Park getInstance(){
        if (null==instance){
            //初始化停车场,停车场长宽不小于3,长宽都是3-10随机长度
            instance = new Park(new Random().nextInt(7)+3,new Random().nextInt(7)+3);
        }
        log.info("初始化停车场,长宽为 " +instance.length + "*" + instance.getWidth());
        return instance;
    }

    @Override
    public String toString() {
        return "Park{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
