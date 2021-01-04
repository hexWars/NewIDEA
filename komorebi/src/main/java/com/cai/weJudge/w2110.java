package com.cai.weJudge;

import java.util.Scanner;

public class w2110 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            for (int i = 1; i <= n; i++) {//行
                for (int j = 0; j < n-i; j++) {//列
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
