package com.cai.school;

public class Work5_7 {
    public static void main(String[] args) {
        double money = 10000, cut = 0, c10 = 0;
        for (int i = 1; i <= 13; i++) {
            money *= 1.05;
            if (i == 10) c10 = money;
            if (i >= 10) cut += money;
        }
        System.out.println("第10年费用为" + c10);
        System.out.printf("费用为%.2f", cut);
    }
}
