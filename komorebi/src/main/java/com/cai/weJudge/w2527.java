package com.cai.weJudge;

import java.util.Arrays;
import java.util.Scanner;

public class w2527 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] cb = new int[200];
        int[] ch = new int[200];
        while (in.hasNext()){
            Arrays.fill(cb,0);
            Arrays.fill(ch,0);
            int w = in.nextInt();
            int cut=0;
            while (w!=0){
                cb[cut++]=w;
                w=in.nextInt();
            }
            for (int i = 0; i < cut; i++) {
                ch[cb[i]]++;
            }
            for (int j = 200; j >=1 ; j--) {
                if (j==1){
                    for (int i = 150; i >= 0; i--) {
                        if (ch[i]==j)
                            System.out.println(i+" occurs "+ch[i]+" time");
                    }
                }else
                for (int i = 150; i >= 0; i--) {
                    if (ch[i]==j)
                        System.out.println(i+" occurs "+ch[i]+" times");
                }
            }
        }
        in.close();
    }
}
