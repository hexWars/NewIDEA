package com.cai.weJudge;

import java.util.Scanner;

public class w2507 {
    public static void fun1(int[] a){
        int w = a[9];
        for (int i = 9; i >0 ; i--) {
            a[i]=a[i-1];
        }
        a[0]=w;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] r = new int[100];
        while (in.hasNext()){
            for (int i = 0; i < 10; i++) {
                int e = in.nextInt();
                r[i]=e;
            }
            for (int i = 0; i < 5; i++) {
                if (i==0)
                System.out.print(r[i]);
                else
                    System.out.print("#"+r[i]);
            }
            System.out.println();
            for (int i = 5; i < 10; i++) {
                if (i==5)System.out.print(r[i]);
                else
                System.out.print("#"+r[i]);
            }
            System.out.println();
            fun1(r);
            for (int i = 0; i < 4; i++) {
                if (i==0) System.out.print(r[i]);
                else
                    System.out.print("*"+r[i]);
            }
            System.out.println();
            for (int i = 4; i < 8; i++) {
                if (i==4)System.out.print(r[i]);
                else
                    System.out.print("*"+r[i]);
            }
            System.out.println();
            for (int i = 8; i < 10; i++) {
                if (i==8)System.out.print(r[i]);
                else
                    System.out.print("*"+r[i]);
            }
            System.out.println();
        }
        in.close();
    }
}
