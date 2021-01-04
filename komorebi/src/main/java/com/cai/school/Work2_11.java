package com.cai.school;

import java.util.Scanner;

public class Work2_11 {
    public static void main(String[] args) {
        int people = 312032486;
        int year = 60 * 60 * 24 * 365;
        int add = year / 7;
        int delete = year / 13;
        int transfer = year / 45;
        int result = people + add - delete + transfer;
        System.out.printf("Enter the number of years: ");
        Scanner in = new Scanner(System.in);
        int actualYear = in.nextInt();
        for (int i = 0, k = 1; i <actualYear ; i++) {
            people+=result;
        }
        System.out.printf("The population in %d year is %d\n",actualYear,people);
    }
}
