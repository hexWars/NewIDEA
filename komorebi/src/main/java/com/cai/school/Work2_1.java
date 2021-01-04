package com.cai.school;

import java.util.Scanner;

public class Work2_1 {
    public static void main(String[] args) {
        System.out.print("Enter a degree in Celsius : ");
        Scanner in = new Scanner(System.in);
        double degreeCentigrade = in.nextDouble();
        double degreeFahrenheit = (9.0/5)*degreeCentigrade + 32;
        System.out.println(degreeCentigrade+" Celsius is "+degreeFahrenheit+" Fahrenheit.");
    }
}
