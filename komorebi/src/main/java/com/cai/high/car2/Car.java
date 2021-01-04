package com.cai.high.car2;

/**
 * @author Cai
 * @time 2020-10-07-9:03
 */
public abstract class Car {
    private String brand;
    private int weight;

    public Car(String brand, int weight) {
        this.brand = brand;
        this.weight = weight;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }
}
