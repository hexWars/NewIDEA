package com.cai.weJudge;

import java.util.Scanner;

public class w2416 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int b=in.nextInt();
            int a=b/100,c=b%10;
            if(a==c){
                System.out.println(b+" is a palondrome");
            }else{
                System.out.println(b+" is not a palondrome");
            }
        }
        in.close();
    }
}

