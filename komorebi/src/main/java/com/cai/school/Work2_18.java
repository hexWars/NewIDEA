package com.cai.school;

public class Work2_18 {
    public static void main(String[] args) {
        System.out.printf("a\tb\tpow(a,b)\n");
        for(int i=1;i<=10;i++){
            System.out.printf("%d\t%d\t%d\n",i,i+1,(int)Math.pow(i,i+1));
        }
    }
}