package com.cai.high.shape;

/**
 * @author Cai
 * @time 2020-09-30-10:23
 */
public class Round extends Shape implements Calculate{
    int r = super.getLen()[0];
    public Round(int n, int[] len) {
        super(n, len);
    }

    @Override
    public double area() {
        return r * r * Math.PI;
    }

    @Override
    public double length() {
        return 2 * Math.PI * r;
    }
}
