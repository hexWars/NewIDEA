package com.cai.high.shape;

/**
 * @author Cai
 * @time 2020-09-30-10:19
 */
public class Rectangle extends Shape implements Calculate {
    int a = super.getLen()[0];
    int b = super.getLen()[1];

    public Rectangle(int n, int[] len) {
        super(n, len);
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double length() {
        return (a + b) * 2;
    }
}
