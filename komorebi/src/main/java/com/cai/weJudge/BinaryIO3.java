package com.cai.weJudge;

import java.io.*;

public class BinaryIO3 {

    public static void main(String[] args) {
        File f = new File("B001.dat");
        try {
            if (f.exists()){
                f.createNewFile();
            }else{
//                PrintWriter pw = new PrintWriter(f);
                FileOutputStream fos = new FileOutputStream(f,true);
                DataOutputStream dos  = new DataOutputStream(fos);
                for (int i = 0; i < 100; i++) {
                    dos.write((int)(Math.random()*101));
//                    pw.printf("%d ",(int)(Math.random()*101));
                }
                dos.close();
                fos.close();
//                pw.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
