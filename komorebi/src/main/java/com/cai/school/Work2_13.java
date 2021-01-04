package com.cai.school;

import java.util.Scanner;

public class Work2_13 {
    public static void main(String[] args) {
        System.out.print("Enter the monthly saving amonut: ");
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        double result = 0;
        for(int i = 0;i<6; i++){
            result = (result+money)*(1+0.00417);
        }
        System.out.println("After the sixth mouth, the account value is $"+(int)(100*result)/100.0);
    }
}