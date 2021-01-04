package com.cai.test;

import java.util.Scanner;

/**
 * @author Cai
 * @time 2020-10-27-21:55
 */
public class Queasiness {
    private int a;
    private int b;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.nextLine();
            for (int i = 0, fun = 0; i < string.length(); i++) {

                if (string.charAt(i) == ' ') {
                    fun = 1;
                }
                if (fun == 0 && (string.charAt(i) <= '9' && string.charAt(i) >= '0' || string.charAt(i) == '.')) {
                    System.out.print("");
                } else if (fun == 0) {
                    System.out.print(string.charAt(i));
                } else {
                    System.out.print(string.charAt(i));
                }
            }
            System.out.println();
        }
    }
}


