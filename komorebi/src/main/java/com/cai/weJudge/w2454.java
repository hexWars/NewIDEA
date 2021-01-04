package com.cai.weJudge;

import java.util.Scanner;

public class w2454 {
    public static boolean fun(int a){
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if(a%i==0)return false;
        }
        return true;
    }

    public static boolean fun2(String a){
        for (int i = 0; i < a.length()/2; i++) {
            char w1 = a.charAt(i),w2 = a.charAt(a.length()-i-1);
            if(w1!=w2)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int a = in.nextInt();
            String b = a+"";
            if(fun(a)&&fun2(b)){
                System.out.println("Remove Successfully");

            }else {
                System.out.println("Ops");
            }
        }
    }
}
