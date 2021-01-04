package com.cai.weJudge;

import java.util.Scanner;

public class w3958 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            for (int i = 1; i <= n; i++) {//3
                for (int j = 1; j <= (i-1)*2; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= n-i+1; j++) {
                    System.out.print(j+" ");
                }
                System.out.println();
            }
        }

    }
}
