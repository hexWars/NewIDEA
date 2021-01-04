package com.cai.school;

import java.util.Scanner;

public class Work3_2 {
    public static void main(String[] args) {
        int number1 = (int) (System.currentTimeMillis() % 10);
        int number2 = (int) (System.currentTimeMillis() / 10 % 10);
        int number3 = (int) (System.currentTimeMillis() / 100 % 10);
        System.out.print("What is " + number1 + " + " + number2 + " + " + number3 + " = ?");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        System.out.println(number1 + "+" + number2 + "+" + number3 + "=" + answer + " is " +
                (number1 + number2 + number3 == answer));
    }
}
