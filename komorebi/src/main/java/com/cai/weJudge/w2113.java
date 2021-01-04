package com.cai.weJudge;

import java.util.Scanner;

public class w2113 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int cut = (int)'A';
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= 2 * n + 1; j++) {
                    if (j > n - i && j <= 2 * n + 1 - (n - i)) {
                        System.out.printf("%c",cut++);
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
            for (int i = 0; i < n * 2 + 1; i++) {
                System.out.printf("%c",cut++);
            }
            System.out.println();
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 1; j <= 2 * n + 1; j++) {
                    if (j > n - i && j <= 2 * n + 1 - (n - i)) {
                        System.out.printf("%c",cut++);
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
        }
    }
}
