package com.cai.school;

import java.util.Scanner;

public class Work2_6 {
    public static void main(String[] args) {
        System.out.print("Enter a number between 0 and 1000:");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt(),total=0;
        while (number>0){
            total += number%10;
            number /= 10;
        }
        System.out.println("The sum of the digits is " + total);
    }
}
