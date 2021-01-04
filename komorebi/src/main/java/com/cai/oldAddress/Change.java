package com.cai.oldAddress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
 
public class Change {
	static void change(String indexstr,String a,String b,
			String c,String d,String e) throws Exception {
		File file = new File("C:\\Users\\ASUS\\Desktop\\adress.txt");
		
		//根据该字符串，查找其在txt所在的一行，然后替换成新的一行，其它行数据不变
		//新的一行
		
		BufferedReader br = new BufferedReader(new FileReader(file));//读文件
		StringBuffer bf = new StringBuffer();
		String rl = null;//临时的每行数据
		
		while ((rl = br.readLine()) != null) {
//			System.out.println(rl.indexOf(indexstr));//打印该字符串是否在此行，是则输出0，否则输出-1
			if (rl.indexOf(indexstr) == 0) { //或者!r1.startsWith(indexstr)
				bf.append(a+" "+b+" "+c+" "+d+" "+e+"\r\n");
			}else {
				bf.append(rl+"\r\n");
			}
		}
		br.close();
		
		BufferedWriter out = new BufferedWriter(new FileWriter(file));//写入文件
		out.write(bf.toString());//把bf写入文件
		out.flush();//一定要flush才能写入完成
		out.close();//关闭
	}
}