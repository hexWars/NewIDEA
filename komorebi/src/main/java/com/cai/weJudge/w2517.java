package com.cai.weJudge;

import java.util.Scanner;

public class w2517 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i==j)continue;
                    else {
                        if (arr[i]==arr[j]){
                            arr[j]=-1111;
                        }
                    }
                }
            }
            for (int i = 0,j = 0; i < 10; i++) {
                if (arr[i]!=-1111){
                    if (j==0){
                        System.out.print(arr[i]);
                    }else {
                        System.out.print(" "+arr[i]);
                    }
                    j++;
                }
            }
            System.out.println();
        }
    }
}
