package com.cai.school;

import java.util.Scanner;

public class Work2_7 {
    public static void main(String[] args) {
        System.out.print("Enter a number of minutes:");
        Scanner in = new Scanner(System.in);
        long minues = in.nextLong(), year, day;
        minues /=60*24;
        year = minues /365;
        day = minues %365;
        System.out.println(minues+" minutes is approximately "
                +year+" years and "+day+" days");
    }
}