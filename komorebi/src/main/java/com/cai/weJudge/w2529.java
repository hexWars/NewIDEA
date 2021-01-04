package com.cai.weJudge;

import java.util.Scanner;

public class w2529 {

    public static String conuertMillis(long num) {
        num /= 1000;
        long c = num % 60;
        num /= 60;
        long b = num % 60;
        num /= 60;
        long a = num;
        return (a + ":" + b + ":" + c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long num = in.nextLong();
            System.out.println(conuertMillis(num));
        }
        in.close();
    }
}
