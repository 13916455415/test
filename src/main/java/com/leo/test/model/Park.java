package com.leo.test.model;

import java.util.Random;

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
            instance = new Park(new Random().nextInt(7)+3,new Random().nextInt(7)+3);
        }
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
