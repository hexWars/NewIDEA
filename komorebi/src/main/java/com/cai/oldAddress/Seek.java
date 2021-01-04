//package NewAddress;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class Seek{
//	static void seek(String idNum) {
//	    String txtPath = "C:\\Users\\ASUS\\Desktop\\adress.txt";
//	    String result = getMatchLine(txtPath, idNum);
////	    System.out.println(txtPath);
//	    if (result == null) {
//	        System.out.println("不存在" + idNum + "的信息。");
//	    } else {
//	        System.out.println("查询成功,信息如下：");
//	        System.out.println(result);
//	    }
//	}
//
//	private static String getMatchLine(String txtPath, String idNum) {
//	    String result = null;
//	    try {
//	        FileReader fr = new FileReader(
//	        		new File("C:\\Users\\ASUS\\Desktop\\adress.txt"));
//	        BufferedReader br = new BufferedReader(fr);
//	        String line = br.readLine();
//	        while (line != null) {
//	            if (line.contains("")) {
//	                result = line;
//	                break;
//	            } else {
//	                line = br.readLine();
//	            }
//	        }
//	    } catch (FileNotFoundException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	    return result;
//	}
//}
