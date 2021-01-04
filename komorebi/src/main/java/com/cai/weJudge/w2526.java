package com.cai.weJudge;

import java.util.Scanner;

public class w2526 {

    public static void changeUpperLowerCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch <= 'z' && ch >= 'a') {
                ch += (int) ('A' - 'a');
                System.out.print(ch);
            } else if (ch <= 'Z' && ch >= 'A') {
                ch -= (int) ('A' - 'a');
                System.out.print(ch);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            changeUpperLowerCase(str);
        }
        in.close();
    }
}
