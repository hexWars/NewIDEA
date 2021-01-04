package com.cai.weJudge;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryIO2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        File file = new File("A001.txt");
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("创建");
                }
            } else {
                Scanner in = new Scanner(file);
                while (in.hasNext()) {
                    list.add(in.nextInt());
                }
                in.close();
                PrintWriter pw1 = new PrintWriter(file);
                int w = 0;
                for (Integer integer : list) {
                    w += integer;
                }
                pw1.printf("%d ", w);
                System.out.println(w);
                System.out.println("长度:" + list.size());
                pw1.close();
            }
        } catch (Exception e) {
            System.out.println("异常");
        }
    }
}
