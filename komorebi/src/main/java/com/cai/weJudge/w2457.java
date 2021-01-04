package com.cai.weJudge;

import java.util.Scanner;

public class w2457 {

    public static boolean fun(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int ans = 0;
            int scale = 17;
            int[] w = new int[10000];
            int k=0;
            while (a > 0) {
                int b = a % scale;
                if (b >= 10) {
                    w[k++]=(b-10+'A')+1000;
                } else {
                    w[k++]=b;
                }
                a /= scale;
            }
            for (int i = k-1; i >= 0; i--) {
                if (w[i]>=1000)
                System.out.print((char) (w[i]-1000));
                else
                    System.out.print(w[i]);
            }
            System.out.println();
        }
        in.close();
    }
}