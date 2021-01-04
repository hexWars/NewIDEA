package com.cai.oldAddress;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputFile {//throw void IOException
	
    static void input (String name,String sex,
    		String phone,String e_mail,String WeChat) {
        File file = new File("C:\\Users\\ASUS\\Desktop\\adress.txt");
        FileWriter fw;
		try {
			fw = new FileWriter(file,true);
//			fw.write("123");
	        fw.write("\r\n");
	        fw.write(name+" "+sex+" "+phone+" "+ e_mail+" "+WeChat);
	        fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //设置成true就是追加
    }
}