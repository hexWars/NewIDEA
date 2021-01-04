package com.cai.weJudge;

import java.util.Scanner;

public class w2439 {
    static boolean fun(int a) {
        for (int i = 2; i <=  Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a>b){
                int swap = a;
                a=b;
                b=swap;
            }
            for (int i = a, j = 0; i <= b; i++) {
                if (i == 1) continue;
                if (fun(i)) {
                    j++;
                    if (j % 10 == 0 && j != 0) {
                        System.out.printf("%d\n", i);
                    } else {
                        System.out.printf("%d ", i);
                    }
                }
                if (i == b) System.out.println();
            }
        }
        in.close();
    }
}