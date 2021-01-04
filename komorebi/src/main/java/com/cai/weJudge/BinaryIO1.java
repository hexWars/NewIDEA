package com.cai.weJudge;

import java.io.File;
import java.io.PrintWriter;

public class BinaryIO1 {
    public static void main(String[] args) {
        File file = new File("A001.txt");
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {//必检异常
                    System.out.println("创建成功");
                }
            } else {
                PrintWriter pw1 = new PrintWriter(file);
                for (int i = 0; i < 100; i++) {
                    pw1.printf("%d ", (int) (Math.random() * 101));
                }
                pw1.close();
            }
        } catch (Exception e) {
            System.out.println("异常");
        }
    }
}
