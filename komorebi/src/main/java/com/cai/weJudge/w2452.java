package com.cai.weJudge;

import java.util.Scanner;

public class w2452 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String pass = scanner.nextLine();
            int i, fig = 0, ff = 1;
            if (pass.length() < 8) {//长度小于8
                System.out.println("NO Password at least 8 digits");
            } else {//长度大于8进入下一轮判断
                for (i = 0; i < pass.length(); i++) {
                    char x = pass.charAt(i);
                    if (Character.isDigit(x) || Character.isLetter(x)) {

                    } else {
                        ff = 0;
                    }
                    if (Character.isDigit(x)) fig++;
                }
                if (ff == 1) {
                    if (fig < 2) {
                        System.out.println("NO Password requires two digits");
                    } else {
                        System.out.println("YES");
                    }
                } else {
                    System.out.println("NO Passwords can only consist of characters and numbers");
                }
            }
        }
        scanner.close();
    }
}
