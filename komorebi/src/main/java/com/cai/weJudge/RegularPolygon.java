package com.cai.weJudge;

import java.util.Scanner;

public class RegularPolygon {
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    public void setN(int n) {
        this.n = n;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public double getSide() {
        return side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public RegularPolygon() {

    }

    public RegularPolygon(int numberOfSide, double side) {
        this.n = numberOfSide;
        this.side=side;
    }

    public RegularPolygon(int numberOfSide, double side, double x, double y) {
        this.n = numberOfSide;
        this.side=side;
        this.x=x;
        this.y=y;
    }

    public double getPerimeter() {
        return n*side;
    }

    public double getArea() {
        return n*side*side/(4*Math.tan(Math.PI/n));  //s为边长
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            double side = input.nextDouble();
            double x = input.nextDouble();
            double y = input.nextDouble();
            // 三种方式构造正多边形，并输出其周长和面积
            RegularPolygon rp1 = new RegularPolygon();
            rp1.setN(n);
            rp1.setSide(side);
            rp1.setX(x);
            rp1.setY(y);
            RegularPolygon rp2 = new RegularPolygon(n, side);
            rp2.setX(x);
            rp2.setY(y);
            RegularPolygon rp3 = new RegularPolygon(n, side, x, y);
            System.out.printf("%d %.2f %.2f %.2f\n", rp1.getN(), rp1.getSide(),
                    rp1.getPerimeter(), rp1.getArea());
            System.out.printf("%d %.2f %.2f %.2f\n", rp2.getN(), rp2.getSide(),
                    rp2.getPerimeter(), rp2.getArea());
            System.out.printf("%d %.2f %.2f %.2f\n", rp3.getN(), rp3.getSide(),
                    rp3.getPerimeter(), rp3.getArea());
        }
        input.close();
    }
}
