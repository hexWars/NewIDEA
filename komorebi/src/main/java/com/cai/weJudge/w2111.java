package com.cai.weJudge;

import java.util.Scanner;

public class w2111 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            for (int i = 1; i <= n ; i++) {//2
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < n - i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
