package com.cai.weJudge;
//
//import java.util.Scanner;
//
//public class Rectangle {
//    double width = 1;
//    double height = 1;
//
//    public Rectangle() {
//    }
//
//    public Rectangle(double width, double height) {
//        this.width = width;
//        this.height = height;
//    }
//
//    public static double getArea(double width, double height){
//        return width*height;
//    }
//
//    public static double getPerimeter(double width, double height){
//        return 2*(width+height);
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            double width = in.nextDouble();
//            double height = in.nextDouble();
//            Rectangle rectangle = new Rectangle(width,height);
//            System.out.printf("%.2f %.2f %.2f %.2f\n",width,height,
//                    getArea(width,height),getPerimeter(width,height));
//        }
//        in.close();
//    }
//}
import java.util.Scanner;

public class Rectangle {
    private double width = 1;
    private double height = 1;
    Rectangle(){
        //this.width = 1;
        //this.height = 1;
    }
    Rectangle(double wight,double height){
        this.height = height;
        this.width = wight;
    }
    double getArea(){
        return this.height * this.width;
    }
    double getPerimeter(){
        return (this.height + this.width) * 2;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            double width,height;
            width = input.nextDouble();
            height = input.nextDouble();
            Rectangle rectangle = new Rectangle(width,height);
            System.out.printf("%.2f %.2f %.2f %.2f\n",width,height,rectangle.getArea(),rectangle.getPerimeter());
        }
        input.close();
    }
}