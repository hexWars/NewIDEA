package com.cai.weJudge;

import java.util.Scanner;

public class w2530 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            int ans = 0;
            for (int i = 1; i < num; i++) {
                if (num%i==0){
                    ans+=i;
                }
            }
            if (ans == num){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}