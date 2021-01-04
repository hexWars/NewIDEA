package com.cai.weJudge;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BinaryIO5 {

    public static void main(String[] args) {
        File f = new File("data.dat");
        try {
            int[] arr = new int[]{6,7,8,9,10};
            Date date = new Date();
            double d = 19.9;

            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i]);
            }
            bw.newLine();

            SimpleDateFormat sdf = new SimpleDateFormat(" yyy-MM-dd HH:mm:ss");
            String str = sdf.format(new Date());
            bw.write(str);
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
