package com.cai.school;

import java.util.Scanner;

public class Work3_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        String num = in.nextLine();
        int sum = 0;
        String copy = num;
        for (int i = 0; i < 9; i++) {
            char oneNum = num.charAt(i);
            sum+=(int)(oneNum-'0')*(i+1);
        }
        if (sum % 11 == 10) {
            System.out.println("The ISBN-10 number is " + copy + "X");
        } else {
            System.out.println("The ISBN-10 number is " + copy + sum % 11);
        }
        in.close();
    }
}
