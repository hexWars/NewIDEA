package com.cai.high.studGameAndIO;

import java.io.*;

/**
 * @author: Cai
 * @date: 2020/11/4 10:51
 * @description:
 */
public class Save {
    public static void main(String[] args) {
        try {
            File file = new File("text1.txt");
            if (file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false);//true代表追加,false,标识向文件中写入会覆盖旧的内容
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Player p1 = new Player("p1", "123", "123", "1", "3");
            Player p2 = new Player("p2", "fgjh", "ewryt", "7", "63");
            Player p3 = new Player("p3", "resd", "135", "16", "6");
            Player p4 = new Player("p4", "1uyrty", "wert", "91", "376");
            Player p5 = new Player("p43", "1djghj", "wdrfthrt", "5461", "3726636");
            bufferedWriter.write(p1 + "\n");
            bufferedWriter.write(p2 + "\n");
            bufferedWriter.write(p3 + "\n");
            bufferedWriter.write(p4 + "\n");
            bufferedWriter.write(p5 + "\n");
            if (bufferedWriter!=null){
                bufferedWriter.close();
            }
            if (fileWriter!=null){
                fileWriter.close();
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
