package com.cai.weJudge;

import java.util.Scanner;

public class w2438 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b;
        while (in.hasNext()){
            a=in.nextInt();
            b=in.nextInt();
            for (int i = b,j=0; i >= a; i--) {
                if (i%3==0||i%4==0){
                    if (i%12!=0){
                        if (j%10==0)
                        System.out.printf("%d",i);
                        else
                            System.out.printf(" %d",i);
                        j++;
                        if (j%10==0&&j!=0){
                            System.out.println();
                        }
                    }
                }
            }
        }
        in.close();
    }
}
