package com.cai.school;

import java.util.Scanner;

public class Work3_23 {
    public static void main(String[] args) {
        double high = 2.5;
        double width = 5;
        System.out.print("Enter a point with two coordinates:");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double a = in.nextDouble();
            double b = in.nextDouble();
            if (Math.abs(a) <= width && Math.abs(b) <= high) {
                System.out.printf("Point ( %.1f, %.1f) is in the rectangle\n", a, b);
            } else {
                System.out.printf("Point ( %.1f, %.1f) is not in the rectangle\n", a, b);
            }
            System.out.print("Enter a point with two coordinates:");
        }
    }
}
