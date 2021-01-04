package com.cai.school;

import java.util.Scanner;

public class Work3_17 {
    public static boolean fun(int a, int b) {
        if (a == 1 && b == 2) {
            return true;
        }
        if (a == 0 && b == 1) {
            return true;
        }
        if (a == 2 && b == 0) {
            return true;
        }
        if (a == 2 && b == 1) {
            return false;
        }
        if (a == 1 && b == 0) {
            return false;
        }
        if (a == 0 && b == 2) {
            return false;
        }
        return false;
    }

    public static String name(int a) {
        if (a == 0) return "scissor";
        else if (a == 1) return "rock";
        else if (a == 2) return "paper";
        return null;
    }

    public static void main(String[] args) {
        System.out.print("scissor (0), rock (1), paper (2):");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int os = (int) (Math.random() * 3);
            int a = in.nextInt();
            if (os == a) {
                System.out.println("The computer is " + name(os) + ". You are " + name(a) + ". It is a draw");
            } else {
                if (fun(os, a)) {
                    System.out.println("The computer is " + name(os) + ". You are " + name(a) + ". You are won");
                } else {
                    System.out.println("The computer is " + name(os) + ". You are " + name(a) + ". You are lose");
                }
            }
        }
        in.close();
    }
}
