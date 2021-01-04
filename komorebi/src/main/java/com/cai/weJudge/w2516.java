package com.cai.weJudge;

import java.util.Scanner;

public class w2516 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[6];
        int[] b = new int[4];
        while (in.hasNext()){
            for (int i = 0; i < 6; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < 4; i++) {
                b[i] = in.nextInt();
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 6; j++) {
                    if (b[i]==a[j]){
                        a[j]=-2147483648;
                    }
                }
            }
            int w = 0;
            for (int i = 0; i < 6; i++) {
                if (a[i]!=-2147483648){
                    if (w==0||w==3){
                        System.out.print(a[i]);
                    }else {
                        System.out.print(" "+a[i]);
                    }
                    if (w==2||w==5) System.out.println();
                    w++;
                }
            }
            System.out.println();
        }
        in.close();
    }
}
