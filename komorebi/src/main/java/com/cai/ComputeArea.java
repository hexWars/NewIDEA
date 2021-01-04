package com.cai;

public class ComputeArea {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            double radius = Double.parseDouble(args[i]);
            System.out.printf("radius is %.2f\narea is %.2f\n",radius,
                    Math.pow(radius,2) * 3.14);
        }
    }
}
