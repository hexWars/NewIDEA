package com.cai.weJudge;

import java.util.Scanner;

public class w2109 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            for (int i = 1; i <= n ; i++) {//2
                for (int j = 1; j <= i; j++) {
//                    System.out.print(j+" ");
                    System.out.print("*");
                }
//                for (int j = 1; j <= 2*(n-i); j++) {
//                    System.out.print(" ");
//                }
                System.out.println();
            }
        }
    }
}
