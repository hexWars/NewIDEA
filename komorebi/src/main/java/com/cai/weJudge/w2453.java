package com.cai.weJudge;

import java.util.Scanner;

public class w2453 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String pass = scanner.nextLine();
            int i, fig = 0, ff = 1;
            if (pass.length() < 6) {//长度小于8
                System.out.println("NO Password at least 6 digits");
            } else {//长度大于8进入下一轮判断
                for (i = 0; i < pass.length(); i++) {
                    char x = pass.charAt(i);
//                    if (x >= '0' && x <= '9' || x >= 97 && x <= 122 || x >= 65 && x <= 90) {
                    if (Character.isDigit(x) || Character.isLetter(x)) {

                    } else {
                        ff = 0;
                    }
                    if (x >= '0' && x <= '9') fig++;
                }
                if (ff == 1) {
                    if (fig < 1) {
                        System.out.println("NO Password is at least one number");
                    } else {
                        System.out.println("YES");
                    }
                } else {
                    System.out.println("NO Passwords can only consist of letters and numbers");
                }
            }
        }
        scanner.close();
    }
}
