package com.cai.weJudge;

import java.util.Scanner;

public class w2456 {

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
            int b = (int)Math.pow(2,a)-1;
            if(fun(a)&&fun(b)){
                System.out.println("Remove Successfully");
            }else {
                System.out.println("Ops");
            }
        }
    }
}
