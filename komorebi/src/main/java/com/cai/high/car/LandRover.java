package com.cai.high.car;

public class LandRover extends Auto {
    private int mirror;
    private int TV;

    public LandRover(int tyre, String color, int weight, int w, int speed, int mirror, int TV) {
        super(tyre, color, weight, w, speed);
        this.mirror = mirror;
        this.TV = TV;
    }
    public void decelerate(int num) {
        super.setSpeed(super.getSpeed()-num);
        System.out.println("已经减速"+num+"/公里");
        System.out.println("LandRover当前时速"+super.getSpeed()+"/公里");
    }

    public void accelerate(int num) {
        super.setSpeed(super.getSpeed()+num);
        System.out.println("已经加速"+num+"/公里");
        System.out.println("LandRover当前时速"+super.getSpeed()+"/公里");
    }
}
