package com.cai.high.shape;

/**
 * @author Cai
 * @time 2020-09-30-10:18
 */
public class Triangle extends Shape implements Calculate {
    int a = super.getLen()[0];
    int b = super.getLen()[1];
    int c = super.getLen()[2];

    public Triangle(int n, int[] len) {
        super(n, len);
    }

    @Override
    public double area() {
        return Math.sqrt(((a + b + c) * (a + b - c) * (a + c - b) * (b + c - a)) / 4);
    }

    @Override
    public double length() {
        return a + b + c;
    }
}
