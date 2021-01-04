package com.cai.weJudge;

import java.util.Scanner;

public class w2436 {
    public static void main(java.lang.String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int to = n;
            int[] a = new int[10000];
            int w = 0;
            while (n > 0) {
                a[w] = n % 16;
                n = n / 16;
                w++;
            }
            for (int i = w-1; i >= 0; i--) {
                if (a[i]>=10){
                    if (a[i]>16){
                        System.out.print('f');
                        a[i+1]++;
                    }else{
                        System.out.printf("%c",(char)a[i]-10+'a');
                    }
                }else{
                    System.out.printf("%d",a[i]);
                }
            }
            System.out.println();
//            System.out.println(Integer.toHexString(to));
        }
        in.close();
    }
}
