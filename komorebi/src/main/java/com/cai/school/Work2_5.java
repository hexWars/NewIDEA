package com.cai.school;

import java.util.Scanner;

public class Work2_5 {
    public static void main(String[] args) {
        System.out.print("Enter the subtotal and a gratuity rate: ");
        Scanner in = new Scanner(System.in);
        double cost = in.nextDouble() ,rate = in.nextDouble()/100;
        System.out.println("The gratuity is $"+ String.format("%.1f",cost*rate)+
                " total is $"+String.format("%.1f",cost+cost*rate));
    }
}
