package com.cai.school;

public class Work5_11 {
    public static void main(String[] args) {
        int cut = 0;
        for (int i = 100; i <= 200; i++) {
            if (i % 5 == 0 && i % 6 == 0) {
                continue;
            }
            if (i % 5 == 0 || i % 6 == 0) {
                cut++;
                if (cut == 1) {
                    System.out.print(i);
                } else if (cut == 10) {
                    cut = 0;
                    System.out.println(" " + i);
                } else {
                    System.out.print(" " + i);
                }
            }
        }
    }
}
