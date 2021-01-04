package com.cai.weJudge;

import java.util.Scanner;

class GeometricObject {
    public GeometricObject() {
    }
}

public class Triangle extends GeometricObject {
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public void toString(String d, String e) {
        System.out.printf("%.2f %.2f %s %s\n", getArea(), getPerimeter(), d, e);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double a = in.nextDouble(), b = in.nextDouble(), c = in.nextDouble();
            String d = in.next(), e = in.next();
            Triangle t = new Triangle(a, b, c);
            t.toString(d, e);
        }
    }
}
