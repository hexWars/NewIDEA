package com.cai.high.shape;

/**
 * @author Cai
 * @time 2020-09-30-10:23
 */
public class Trapezoid extends Shape implements Calculate{
    int a = super.getLen()[0];
    int b = super.getLen()[1];
    int c = super.getLen()[2];
    int d = super.getLen()[3];
    int e = super.getLen()[4];
    public Trapezoid(int n, int[] len) {
        super(n, len);
    }

    @Override
    public double area() {
        return (a + b) * e / 2;
    }

    @Override
    public double length() {
        return a + b + c + d;
    }
}
