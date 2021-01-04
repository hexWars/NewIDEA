package com.cai.weJudge;

import java.util.Scanner;

public class w2505 {
    public static double min(double[] array) {
        double w = 10000;
        for (int i = 0; i < 10; i++) {
            if(array[i]<w){
                w=array[i];
            }
        }
        return w;
    }

    public static double max(double[] array) {
        double w = -10000;
        for (int i = 0; i < 10; i++) {
            if (array[i]>w){
                w=array[i];
            }
        }
        return w;
    }

    public static double average(double[] array) {
        double sum=0;
        for (int i = 0; i < 10; i++) {
            sum+=array[i];
        }
        return sum/10;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] a = new double[1000];
        while (in.hasNext()){
            for (int i = 0; i < 10; i++) {
                a[i]=in.nextDouble();
            }
            System.out.printf("%.2f\n",min(a));
            System.out.printf("%.2f\n",max(a));
            System.out.printf("%.2f\n",average(a));
        }
        in.close();
    }
}
