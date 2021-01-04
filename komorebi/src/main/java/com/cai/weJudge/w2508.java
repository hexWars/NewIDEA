package com.cai.weJudge;

import java.util.Arrays;
import java.util.Scanner;

public class w2508 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] b = new int[1000];
        while (in.hasNext()) {
            Arrays.fill(b,0);
            for (int i = 0; i < 10; i++) {
                int e = in.nextInt();
                b[e]++;
            }
            int max=-1000;
            for (int i = 0; i < 900; i++) {
                if (b[i]>max){
                    max=b[i];
                }
            }
            for (int i = 0; i < 900; i++) {
                if (b[i]==max){
                    System.out.println(i+" "+b[i]);
                }
            }
        }
        in.close();
    }
}
