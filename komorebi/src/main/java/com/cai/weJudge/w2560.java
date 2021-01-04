package com.cai.weJudge;

import java.util.Date;
import java.util.Scanner;

public class w2560 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            long da = in.nextLong();
            Date date = new Date(da);
            System.out.println(date.toString());
        }
        in.close();
    }
}
