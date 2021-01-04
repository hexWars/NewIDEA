package com.cai.weJudge;

import java.util.Scanner;

public class w2543 {

    public static void binSearch(int[] list, int key) {
        int[] index = new int[list.length];
        int cut = 0;
        int key2 = 0;
//        int left = 0;
//        int right = list.length-1;
        for (int i = 0; i < list.length; i++) {
            if (key == list[i]) {
                index[cut++] = i;
//                System.out.println("#"+i);
            }
            if (i != 0) {
                if (list[i - 1] < key && list[i] > key) {
                    key2 = i;
                }
            }
            if (key<list[0]){
                key2=0;
                break;
            }
            if (key>list[list.length-1]){
                key2=list.length;
            }
            if (list.length == 1) {
                if (list[0] > key) {
                    key2 = 0;
                } else if (list[0] < key) {
                    key2 = 1;
                }
            }
        }
        if (cut == 0) {
            System.out.println((-key2 - 1));
        } else if (cut == 1) {
            System.out.println(index[0]);
        } else {
            System.out.println(index[0] + " " + index[cut - 1]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int key = in.nextInt();
            int len = in.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = in.nextInt();
            }
            binSearch(arr, key);
        }
        in.close();
    }
}
