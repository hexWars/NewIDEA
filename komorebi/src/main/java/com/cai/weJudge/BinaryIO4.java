package com.cai.weJudge;

import java.io.*;

public class BinaryIO4 {
    public static void main(String[] args) {
        File f = new File("B001.dat");
        try {
            FileInputStream fis = new FileInputStream(f);
//            DataInputStream dis = new DataInputStream(fis);
            int a = 0;
            int i=0;
            long sun=0;
            while((a=fis.read())!=-1){
                if(i%10==0&&i!=0){
                    System.out.println();
                }
                System.out.println(a+" ");
                sun+=a;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
