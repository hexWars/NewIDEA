package com.cai.weJudge;

import java.util.Scanner;

public class MyVector {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            double[] v1 = new double[n];
            double[] v2 = new double[n];
            for (int i = 0; i < n; i++) {
                v1[i] = in.nextDouble();
            }
            for (int i = 0; i < n; i++) {
                v2[i] = in.nextDouble();
            }
            System.out.printf("(");
            for (int i = 0; i < n; i++) {
                System.out.printf("%.2f",v1[i]*v2[i]);
                if(i!=n-1){
                    System.out.printf(", ");
                }
            }
            System.out.println(")");
            System.out.printf("(");
            for (int i = 0; i < n; i++) {
                System.out.printf("%.2f",v1[i]+v2[i]);
                if(i!=n-1){
                    System.out.printf(", ");
                }
            }
            System.out.println(")");
        }
    }
}
