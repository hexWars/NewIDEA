package com.cai.oldAddress;

import java.io.BufferedReader;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.InputStreamReader;

public class NewSeek { 

  public static void readTxtFile(String filePath,String a){ 
    try { 
        String encoding="GBK"; 
        File file=new File(filePath); 
        if(file.isFile() && file.exists()){ //判断文件是否存在 
          InputStreamReader read = new InputStreamReader( 
          new FileInputStream(file),encoding);//考虑到编码格式 
          BufferedReader bufferedReader = new BufferedReader(read); 
          String lineTxt = null; 
          while((lineTxt = bufferedReader.readLine()) != null){ 
//            System.out.println(lineTxt);
        	  if(ThroughIndexOf(lineTxt,a)) {
        		  System.out.println(lineTxt);
        	  }
          } 
          read.close(); 
    }else{ 
      System.out.println("找不到指定的文件"); 
    } 
    } catch (Exception e) { 
      System.out.println("读取文件内容出错"); 
      e.printStackTrace(); 
    } 
    
  } 
    
  static void fun(String a){ 
    String filePath = "C:\\Users\\ASUS\\Desktop\\adress.txt"; 
//   "res/"; 
    readTxtFile(filePath,a); 
  } 
  	public static boolean ThroughIndexOf(String parent,String child){

	  int count=0;

	  int StartIndex=0;

	  while(parent.indexOf(child,StartIndex)!=-1){

	  StartIndex = parent.indexOf(child,StartIndex);

	  StartIndex+=child.length();

	  count++;

	  }
//	  System.out.print("The number of matches is:"+count+"\n");
	  if(count>0) {
		  return true;
	  }
	  else {
		  return false;
	  }
	  }
} 
