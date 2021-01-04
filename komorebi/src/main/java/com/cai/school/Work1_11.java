package com.cai.school;

public class Work1_11 {
    public static void main(String[] args) {
        int people = 312032486;
        int year = 60 * 60 * 24 * 365;
        int add = year / 7;
        int delete = year / 13;
        int transfer = year / 45;
        int result = people+add-delete+transfer;
        System.out.println("未来5年的人口数量:");
        for (int i = 0, k = 1; i < 5; i++) {
            System.out.printf("第%d年的人口数量是:", k++);
            System.out.println(people+=result);
        }
    }
}
