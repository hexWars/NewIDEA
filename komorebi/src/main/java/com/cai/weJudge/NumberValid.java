package com.cai.weJudge;

import java.util.Scanner;

public class NumberValid {

    public static Boolean isBin(String cb) {
//        String regex="[0-1]+$";
//        if(cb.matches(regex)) {
//            return true;
//        }else {
//            return false;
//        }
        if (cb.charAt(0)=='-'||cb.charAt(0)=='+'){
            cb=cb.substring(1);
        }
        if (cb.length()<=2){
            return false;
        }
        char a = cb.charAt(0), b = cb.charAt(1);
        if (a == '0' && b == 'b' || a == '0' && b == 'B') {
            for (int i = 2; i < cb.length(); i++) {
                char c = cb.charAt(i);
                if (c == '0' || c == '1') {

                } else {
                    System.out.println(c);
                    System.out.println("***");
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static Boolean isOct(String cb) {
//        String regex="[0-7]+$";
//        if(cb.matches(regex)) {
//            return true;
//        }else {
//            return false;
//        }
        if (cb.charAt(0)=='-'||cb.charAt(0)=='+'){
            cb=cb.substring(1);
        }
        if (cb.length()<=1){
            return false;
        }
        char a = cb.charAt(0);
        if (a == '0') {
            for (int i = 1; i < cb.length(); i++) {
                char c = cb.charAt(i);
                if (c >= '0' && c <= '7') {

                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;

    }

    public static Boolean isHex(String cb) {
//        String regex="[A-Fa-f0-9]+$";
//        if(cb.matches(regex)) {
//            return true;
//        }else {
//            return false;
//        }
        if (cb.charAt(0)=='-'||cb.charAt(0)=='+'){
            cb=cb.substring(1);
        }
        if (cb.length()<=2){
            return false;
        }
        char a = cb.charAt(0), b = cb.charAt(1);
        if (a == '0' && b == 'x' || a == '0' && b == 'X') {
            for (int i = 2; i < cb.length(); i++) {
                char c = cb.charAt(i);
                if (c >= '0' && c <= '9' || c >= 'A' && c <= 'F' || c >= 'a' && c <= 'f') {

                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static Boolean isInt(String cb) {
        if (cb.charAt(0)=='-'||cb.charAt(0)=='+'){
            cb=cb.substring(1);
        }
        String regex = "[0-9]+$";
        if (cb.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String v = input.next();
            System.out.printf("%b %b %b %b\n", NumberValid.isBin(v), NumberValid.isOct(v),
                    NumberValid.isHex(v), NumberValid.isInt(v));
        }

    }
}
