package com.cai.weJudge;

import java.util.InputMismatchException;
import java.util.Scanner;

public class w2605 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            try {
                int a=in.nextInt();
                int b = in.nextInt();
                int c = a+b;
                System.out.println(c);
            }catch (InputMismatchException e){
                System.out.println("Wrong input!Please enter int value.");
                in.nextLine();
            }
        }
    }
}
