package com.cai.weJudge;

import java.util.Scanner;

public class w2528 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        while (in.hasNext()){
            for (int i = 0; i < 10; i++) {
                arr[i]=in.nextInt();
            }
            int format = in.nextInt();
            int cut=0;
            int w=0;
            while (true){

                for (int i = 0; i < format; i++) {
                    if (cut>=10){
                        w=1;break;
                    }
                    if (i==0){
                        System.out.print(arr[cut]);
                    }else {
                        System.out.print(" " + arr[cut]);
                    }
                    cut++;
                }
                if (w==1)break;
                System.out.println();
            }
        }
        in.close();
    }
}
