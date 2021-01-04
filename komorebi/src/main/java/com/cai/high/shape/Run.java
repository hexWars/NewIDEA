package com.cai.high.shape;

import java.util.Scanner;

/**
 * @author Cai
 * @time 2020-09-30-10:24
 */
public class Run {
    public static void main(String[] args) {
        System.out.println(1+"三角形");
        System.out.println(2+"矩形");
        System.out.println(3+"梯形");
        System.out.println(4+"圆形");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            int[] len = new int[num+100];
            switch (num){
                case 1:
                    System.out.println("请输入三个边:");
                    for (int i = 0; i < 3; i++) {
                        len[i] = in.nextInt();
                    }
                    Triangle t = new Triangle(num,len);
                    System.out.println("面积为"+t.area()+",周长为"+t.length());
                    break;
                case 2:
                    System.out.println("请输入长和宽:");
                    for (int i = 0; i < 2; i++) {
                        len[i] = in.nextInt();
                    }
                    Rectangle r = new Rectangle(num,len);
                    System.out.println("面积为"+r.area()+",周长为"+r.length());
                    break;
                case 3:
                    System.out.println("请输入上底,下底,两个侧边,以及高");
                    for (int i = 0; i < 5; i++) {
                        len[i] = in.nextInt();
                    }
                    Trapezoid tr = new Trapezoid(num,len);
                    System.out.println("面积为"+tr.area()+",周长为"+tr.length());
                    break;
                case 4:
                    System.out.println("请输入半径");
                    for (int i = 0; i < 1; i++) {
                        len[i] = in.nextInt();
                    }
                    Round ro = new Round(1,len);
                    System.out.println("面积为"+ro.area()+",周长为"+ro.length());
                    break;
            }
        }
    }
}
