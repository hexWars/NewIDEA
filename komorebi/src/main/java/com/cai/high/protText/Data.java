package com.cai.high.protText;

import java.util.Scanner;

/**
 * @author Cai
 * @create 2020-09-27-20:45
 */
public class Data {//35*5
    private double[][] data = new double[5][35];

    public double[][] getData() {
        return data;
    }

    public void setData() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 35; j++) {
                data[i][j] = in.nextDouble();
            }
        }
    }

}
