package com.cai.weJudge;

import java.util.Scanner;

public class w2461 {

    public static boolean fun(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = 0;
            for (int i = a, j = 0; i <= b; i++) {
                if (i>=2)
                if (i == 2 || fun(i)) {
                    System.out.print(i + " ");
                    j++;
                    if (j % 5 == 0) System.out.println();
                    c=j;
                }
            }
            if(c%5!=0) System.out.println();
        }
        in.close();
    }
}
