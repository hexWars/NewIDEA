package com.cai.weJudge;

import java.util.Scanner;

public class w2459 {

    public static boolean fun(int a){
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if(a%i==0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int a = in.nextInt();
            for (int i = 3; i < a-2; i++) {
                if (fun(i)&&fun(i+2)){
                    System.out.println("( "+i+","+(i+2)+" )");
                }
            }
        }
        in.close();
    }
}
