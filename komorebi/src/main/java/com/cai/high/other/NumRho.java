package com.cai.high.other;

import java.util.Scanner;

public class NumRho {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] intArr = new int[str.length()];
        String strArr = "";
        int t=0,cut=0;
        for (int i = 0; i < str.length(); i++) {
            char one = str.charAt(i);
            if (one>='0'&&one<='9'){
                intArr[t++] = (int) one-(int)'0';
                cut++;
            }else{
                strArr+=one;
            }
        }
        for (int i = 0; i < cut; i++) {
            if (i!=0){
                System.out.print(","+intArr[i]);
            }else{
                System.out.print(intArr[i]);
            }
        }
        System.out.println();
        for (int i = 0; i < strArr.length(); i++) {
            char ch = strArr.charAt(i);
            if (i!=0){
                System.out.print(","+ch);
            }else{
                System.out.print(ch);
            }
        }
        System.out.println();
    }
}
