package com.cai.weJudge;

import java.util.Scanner;

public class w2435 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[10000];
        int z=0,f=0,i;
        double sum=0;
        for (i = 0;  ; i++) {
            a[i] = in.nextInt();
            if (a[i]>0)z++;
            if (a[i]<0)f++;
            sum+=a[i];
            if(a[i]==0)break;
        }
        System.out.printf("%d %d %.2f %.2f",z,f,sum,sum/i);
        in.close();
    }
}
