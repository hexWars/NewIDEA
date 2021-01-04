package com.cai.high.car;

public class BlueBird extends Auto {
    private int air;

    public BlueBird(int tyre, String color, int weight, int w, int speed, int air) {
        super(tyre, color, weight, w, speed);
        this.air = air;
    }
    public void decelerate(int num) {
        super.setSpeed(super.getSpeed()-num);
        System.out.println("已经减速"+num+"/公里");
        System.out.println("BlueBird当前时速"+super.getSpeed()+"/公里");
    }

    public void accelerate(int num) {
        super.setSpeed(super.getSpeed()+num);
        System.out.println("已经加速"+num+"/公里");
        System.out.println("BlueBird当前时速"+super.getSpeed()+"/公里");
    }
}
