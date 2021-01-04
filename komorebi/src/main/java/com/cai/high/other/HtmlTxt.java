//package high;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//
//public class HtmlTxt {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br=new BufferedReader(new FileReader("C:/Users/caiweijie/Desktop/text.html"));
//        String str ="";
//        int count=0;
//        while((str=br.readLine())!=null){
//            System.out.println(str);
//            for(int i=0;i<str.length()-1;i++){
//                if (str.charAt(i)=='新'&&str.charAt(i+1)=='浪')
//                    count++;
//            }
//        }
//        System.out.println("出现"+count+"次");
//        br.close();
//    }
//}