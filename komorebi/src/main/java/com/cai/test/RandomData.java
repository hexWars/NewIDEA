package com.cai.test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author: Cai
 * @date: 2020/12/4 13:35
 * @description:
 */
public class RandomData {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new GregorianCalendar();
        String[] s = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int cnt = 1;
        while (scanner.hasNext()) {
            Integer year = scanner.nextInt();
            Integer month = scanner.nextInt();
            Integer day = scanner.nextInt();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            System.out.printf("Case #%d:\n",cnt++);
            System.out.println(s[calendar.get(Calendar.DAY_OF_WEEK) - 2]);
        }
    }
}


