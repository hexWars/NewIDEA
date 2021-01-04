package com.cai.high.studGameAndIO.failure;

import com.cai.high.studGameAndIO.Player;

import java.io.*;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

public class IOAndView {
    static class ReadLines4Product {

        private static Set<String> filesName = new HashSet<>();//文件夹名称
        private static Set<String> fileType = new HashSet<>();//文件类型
        private static int lines = 0;//总行数


        public static int readLines() {
            //将不需要计算入源码行数的 文件夹名字 存储起来
//            filesName.add("upload");

            //将需要计算入源码行数的文件类型  后缀 存储起来
            fileType.add(".txt");


            //查询的根路径
            File file = new File("D:/Mycode/Java/NewIDEA");
            forLines(file);//调用迭代方法

            System.out.println("行数" + (lines - 1));
            return lines - 1;
        }


        /**
         * 用来迭代的方法
         *
         * @param file
         */
        public static void forLines(File file) {
            if (file.isDirectory()) {//是----文件夹
                File[] files = file.listFiles(new FilenameFilter() {//返回true，即为满足条件的文件或者文件夹 ，保存在文件数组中
                    @Override
                    public boolean accept(File file, String name) {
                        if (filesName.contains(name)) { //如果文件夹的名字符合集合内的任何一个，则排除
                            return false;
                        } else if (name.lastIndexOf(".") != -1 && fileType.contains(name.substring(name.lastIndexOf("."))) || new File(file, name).isDirectory()) {
                            //如果file文件名中包含. 则是文件，否则是文件夹  &&  并且文件后缀是包含于文件类型集合
                            return true;
                        }
                        return false;
                    }
                });
                //循环File[]数组
                for (File f : files) {
                    forLines(f);
                }
            } else {//是----文件
                try {
                    lines += Files.lines(file.toPath()).count();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Player[] players = new Player[1000];
        int line = ReadLines4Product.readLines();
        try (BufferedReader br = new BufferedReader(new FileReader("text1.txt"))) {
            String strAll;
            int a = 0;
            while ((strAll = br.readLine()) != null) {
                int num = 0;
                for (int i = 0; i < strAll.length(); i++) {
                    if (strAll.charAt(i) == ' ') {
                        num++;
                    }
                }
                String arr1[] = strAll.split(" ");
                for (int i = 0; i <= num; i++) {
                    System.out.print(arr1[i] + " ");
                }
                players[a++] = new Player(arr1[0], arr1[1], arr1[2], arr1[3], arr1[4]);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
