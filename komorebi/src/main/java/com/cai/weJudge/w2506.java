package com.cai.weJudge;

import java.util.Arrays;
import java.util.Scanner;

public class w2506 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] b = new int[1000];
        while (in.hasNext()) {
            Arrays.fill(b,0);
            int e = in.nextInt();
            for (; ; ) {
                if (e == 0) break;
                b[e]++;
                e = in.nextInt();
            }
            for (int i = 0; i < 105; i++) {
                if (b[i] != 0 && i != 0) {
                    if (b[i] == 1)
                        System.out.printf("%d occurs %d time\n", i, b[i]);
                    else
                        System.out.printf("%d occurs %d times\n", i, b[i]);
                }
            }
        }
        in.close();
    }
}
