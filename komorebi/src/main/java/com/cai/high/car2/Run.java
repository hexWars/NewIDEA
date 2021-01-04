package com.cai.high.car2;

/**
 * @author Cai
 * @time 2020-10-07-9:09
 */
public class Run {
    public static void main(String[] args) {
        Tractors tractors = new Tractors("三菱",1000);
        Truck truck = new Truck("奔驰",34939);
        Sedan sedan = new Sedan("日产",393);
        System.out.println(tractors.toString());
        System.out.println(tractors.getBrand());
        System.out.println(tractors.getWeight());
        System.out.println(truck.toString());
        System.out.println(truck.getBrand());
        System.out.println(truck.getWeight());
        System.out.println(sedan.toString());
        System.out.println(sedan.getBrand());
        System.out.println(sedan.getWeight());
    }
}
