package com.cai.weJudge;

import java.util.Scanner;

public class w2510 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int[] a = new int[100];
            for (int i = 0; i < 10; i++) {
                a[i]=in.nextInt();
            }
            int max=-100;
            for (int i = 0; i < 10; i++) {
                if (a[i]>max)max=a[i];
            }
            System.out.printf("Max:%d at position:",max);
            for (int i = 0; i < 10; i++) {
                if (a[i]==max) System.out.print(" "+i);
            }
            System.out.println();
            int min=100000;
            for (int i = 0; i < 10; i++) {
                if (a[i]<min)min=a[i];
            }
            System.out.printf("Min:%d at position:",min);
            for (int i = 0; i < 10; i++) {
                if (a[i]==min) System.out.print(" "+i);
            }
            System.out.println();
        }
        in.close();
    }
}
