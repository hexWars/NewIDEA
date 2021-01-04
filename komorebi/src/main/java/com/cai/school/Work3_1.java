package com.cai.school;

import java.util.Scanner;

public class Work3_1 {
    public static void main(String[] args) {
        System.out.print("Enter a ,b ,c : ");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            double triangle = (Math.pow(b, 2) - 4 * a * c);
            if (triangle > 0) {
                System.out.printf("The equation has two roots %.6f and %.6f",
                        ((-b) + Math.sqrt(triangle)) / 2 / a, ((-b) - Math.sqrt(triangle)) / 2 / a);
            } else if (triangle == 0) {
                System.out.printf("The equation has one root %.6f", (-b) / 2 / a);
            } else {
                System.out.println("The equation has no real roots ");
            }
        }
        in.close();
    }
}
