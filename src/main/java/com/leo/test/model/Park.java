package com.leo.test.model;

public class Park {
    private int length;
    private int width;
    public Park(int length,int width){
        this.length=length;
        this.width=width;
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
