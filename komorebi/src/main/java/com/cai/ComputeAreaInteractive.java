package com.cai;

import java.util.Scanner;

public class ComputeAreaInteractive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()){
            double radius = in.nextDouble();
            System.out.println(String.format("radius is %.2f\narea is %.2f",radius,Math.pow(radius,2)*3.14));
        }
    }
}
