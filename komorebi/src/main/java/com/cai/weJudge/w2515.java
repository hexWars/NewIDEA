package com.cai.weJudge;

import java.util.Scanner;

public class w2515 {

    public static int fun(int[] a,int[] b){
        if (a[0]==b[0])
            if(a[1]==b[1])
                if(a[2]==b[2])
                    if(a[3]==b[3])
                        if(a[4]==b[4]){
                            return 0;
                        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (a[j]>a[j+1]){
                    int swap = a[j];
                    a[j] = a[j+1];
                    a[j+1] = swap;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (b[j]>b[j+1]){
                    int swap = b[j];
                    b[j] = b[j+1];
                    b[j+1] = swap;
                }
            }
        }
        if (a[0]==b[0])
            if(a[1]==b[1])
                if(a[2]==b[2])
                    if(a[3]==b[3])
                        if(a[4]==b[4]){
                            return 1;
                        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int[] arr1 = new int[5];
            int[] arr2 = new int[5];
            for (int i = 0; i < 5; i++) {
                arr1[i] = in.nextInt();
            }
            for (int i = 0; i < 5; i++) {
                arr2[i] = in.nextInt();
            }
            System.out.println(fun(arr1,arr2));
        }
        in.close();
    }
}
