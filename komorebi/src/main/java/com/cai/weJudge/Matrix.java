package com.cai.weJudge;

import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            if (num <= 0) {
                System.out.println("ERROR!");
            } else {
                if (num == 1) {
                    double ans = in.nextDouble();
                    System.out.printf("%.2f\n", ans);
                    System.out.printf("%.2f\n", ans);
                } else {
                    double[][] cb = new double[num][num];
                    double sum = 0;
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            cb[i][j] = in.nextDouble();
                            sum+=cb[i][j];
                        }
                    }
                    System.out.printf("%.2f\n",sum);
                    if (num%2==0){
                        System.out.printf("%.2f %.2f\n",cb[num/2-1][num/2-1],cb[num/2-1][num/2]);
                        System.out.printf("%.2f %.2f\n",cb[num/2][num/2-1],cb[num/2][num/2]);
                    }else {
                        System.out.printf("%.2f\n",cb[num/2][num/2]);
                    }
                }
            }
        }
    }
}
