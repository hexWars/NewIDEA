package com.cai.high.shape;

/**
 * @author Cai
 * @time 2020-09-30-10:13
 */
public abstract class Shape {
    private int n;
    private int[] len = new int[n + 10];

    public void setN(int n) {
        this.n = n;
    }

    public void setLen(int[] len) {
        this.len = len;
    }

    public int getN() {
        return n;
    }

    public int[] getLen() {
        return len;
    }

    public Shape(int n, int[] len) {
        this.n = n;
        this.len = len;
    }
}
