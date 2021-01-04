package com.cai.weJudge;

import java.util.Scanner;

public class w2455 {
    public static boolean fun(int a){
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if(a%i==0)return false;
        }
        return true;
    }

    public static boolean fun3(int a){
        int w = a,e=0,ans=0;
        while (w>0){
            w/=10;
            e++;
        }
        for (int i = e-1; i >= 0; i--) {
            ans+=(a%10)*Math.pow(10,i);
            a/=10;
        }
        if(fun(ans))return true;
        else
        return false;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int a=in.nextInt();
            if (fun(a)&&fun3(a)){
                System.out.println("Remove Successfully");
            }else {
                System.out.println("Ops");
            }
        }
    }
}
