package com.cai.oldAddress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Delete{
	static void delete(String special) throws Exception{
		File file = new File("C:\\Users\\ASUS\\Desktop\\adress.txt");
		String rl = null;
		StringBuffer bf = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(file));
		while(( rl = br.readLine()) != null){
			rl = rl.trim();
			if(rl.indexOf(special) == -1){ //或者!r1.startsWith(special)
			bf.append(rl).append("\r\n");
//				bf.append(rl).append("\n");
			}
		}
		br.close();
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		out.write(bf.toString());
		out.flush();
		out.close();
	}
}
