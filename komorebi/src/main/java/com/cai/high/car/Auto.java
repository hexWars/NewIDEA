package com.cai.high.car;

public abstract class  Auto {
    private int tyre = 4;
    private String color;
    private int weight;
    private int w;
    private int speed;

    public Auto(int tyre, String color, int weight, int w, int speed) {
        this.tyre = tyre;
        this.color = color;
        this.weight = weight;
        this.w = w;
        this.speed = speed;
    }

    public void stop() {
        this.speed = 0;
        System.out.println("已经停车");
    }

    public void decelerate(int num) {
        this.speed-=num;
        System.out.println("已经减速"+num+"/公里");
        System.out.println("当前时速"+this.speed+"/公里");
    }

    public void accelerate(int num) {
        this.speed+=num;
        System.out.println("已经加速"+num+"/公里");
        System.out.println("当前时速"+this.speed+"/公里");
    }

    public int getTyre() {
        return tyre;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public int getW() {
        return w;
    }

    public int getSpeed() {
        return speed;
    }

    public void setTyre(int tyre) {
        this.tyre = tyre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
