package com.cai.weJudge;

import java.util.Scanner;

class House implements Comparable<House> {
    private double unitPrice; //单价
    private double area;//面积

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getArea() {
        return area;
    }

    public House() {
        this.unitPrice = 0;
        this.area = 0;
    }

    public House(double unitPrice, double area) {
        this.unitPrice = unitPrice;
        this.area = area;
    }

    public double getPrice() {
        return this.unitPrice * this.area;
    }

    @Override
    public int compareTo(House o) {
        if (this.getPrice() > o.getPrice()) {
            return -1;
        } else if (this.getPrice() < o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.format("UnitPrice:%.2f Area:%.2f Total：%.2f", this.unitPrice, this.area, this.getPrice());
    }
}

public class TestHouse {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            //构造五套房子 （单价，面积）
            House[] houses = new House[1000];
            int i;
            for (i = 0; ; i++) {
                double a=input.nextDouble(), b=input.nextDouble();
                if (a==-1&&b==-1)break;
                houses[i] = new House(a,b);
            }
            //房子按总价排序
            java.util.Arrays.sort(houses,0,3);
            for (int j = 0; j < 3; j++) {
                System.out.println(houses[j]);
            }
        }
        input.close();

    }

}
