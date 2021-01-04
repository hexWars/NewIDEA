package com.cai.weJudge;

import java.util.Scanner;

public class w2525 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int ans = 0;
            String str = in.nextLine();
            char a = str.charAt(str.length()-1);
            for (int i = 0; i < str.length() - 2; i++) {
                char b = str.charAt(i);
                if (a == b){
                    ans++;
                }
            }
            System.out.println(ans);
        }
        in.close();
    }
}
