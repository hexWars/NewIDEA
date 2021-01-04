package com.cai.weJudge;

import java.util.Scanner;

public class w3959 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 1; i <= n; i++) {//行
                for (int j = 0; j < n-i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= i-1; j++) {
                    System.out.print(" "+j);
                }
                System.out.print(" "+i);
                for (int j = i-1; j > 0; j--) {
                    System.out.print(" "+j);
                }
                System.out.println();
            }
            for (int i = 1; i <= n-1; i++) {//行
                for (int j = 1; j <= i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= n-i-1; j++) {
                    System.out.print(" "+j);
                }
                System.out.print(" "+(n-i));
                for (int j = n-i-1; j >=1; j--) {
                    System.out.print(" "+j);
                }
                System.out.println();
            }
        }
    }
}