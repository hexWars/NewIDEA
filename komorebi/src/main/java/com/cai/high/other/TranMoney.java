package com.cai.high.other;

import java.util.Scanner;

public class TranMoney {
    static String[] str = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    static String[] str2 = {"拾", "佰", "仟", "万", "亿", "元", "角", "分"};

    public static String fun(long num) {
        String ans = "";
        if (num / 1000 != 0) {//千
//            if (num / 1000 != 1)
            ans += str[(int)(num / 1000)];
            ans += str2[2];
        }
        if (num % 1000 / 100 != 0) {//百
            ans += str[(int)(num % 1000 / 100)];
            ans += str2[1];
        } else if (num % 1000 / 100 == 0 && num / 1000 != 0) {
            ans += str[0];
        }
        if (num % 100 / 10 != 0) {//10
            ans += str[(int)(num % 100 / 10)];
            ans += str2[0];
        } else if ((num % 1000 / 100 != 0 && num % 100 / 10 == 0 || num % 100 / 10 == 0 && num / 1000 != 0) && ans.charAt(ans.length() - 1) != '零') {
            ans += str[0];
        }
        if (num % 10 != 0) {
            ans += str[(int) (num % 10)];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double dou = in.nextDouble();
//            System.out.println(dou);
            long num = (long) dou;
//            System.out.println(num);
            int len = ((int) num + "").length();
            int a = (int) (dou * 100 % 100 / 10);//角
            int b = (int) (dou * 100 % 10);//分
            long n9, n5;
            if (len >= 9) {//过亿
                n9 = num / 100000000;
//                System.out.println(n9);
//                System.out.println(num);
                System.out.print(fun(n9) + str2[4]);
            }
            if (len >= 5) {
                n5 = num / 10000;
//                System.out.println(num);
//                System.out.println(n5);
//                if (num / 1000000000 > 0) {//过亿,把那段截出来
//                    n5 -= num / 1000000000;
//                    System.out.println(n5);
//                }
                if (n5 >= 10000) {
                    n5 %= 10000;
//                    System.out.println(n5);
                }
                System.out.print(fun(n5) + str2[3]);
            }
            System.out.print(fun(num % 10000) + str2[5]);//千
            if (a!=0&&b == 0) {
                System.out.println(str[a] + str2[6]);//小数点后
            } else if (a==0&&b==0) {
                System.out.println();
            } else {
                System.out.println(str[a] + str2[6] + str[b] + str2[7]);//小数点后
            }
        }
    }
}
