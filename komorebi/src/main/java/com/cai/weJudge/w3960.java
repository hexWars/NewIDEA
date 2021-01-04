package com.cai.weJudge;

import java.util.Scanner;

public class w3960 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            for (int i = 1,cut=1; i <= n*2-1; i++) {
                int w = i;
                if (i>n){
                    w=i-cut*2;
                    cut++;
                }
                for (int j = 0; j < n - w; j++) {
                    System.out.print("  ");
                }

                for (int j = w; j >= 1; j--) {
                    System.out.print(" "+j);
                }
                for (int j = 2; j <= w; j++) {
                    System.out.print(" "+j);
                }
                System.out.println();
            }
        }
    }
}