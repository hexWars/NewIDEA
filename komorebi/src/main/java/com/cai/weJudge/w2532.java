package com.cai.weJudge;

import java.util.Scanner;

public class w2532 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        while(input.hasNext()){
            String st = input.next();
            st=st.toUpperCase();
            str=st;
            int i;
            String sum="";
            for(i=0;i<str.length();i++){
                if(str.charAt(i)=='.') {
                    str=str.replace(str.charAt(i),'1');
                    sum+=str.charAt(i);
                }

                else if(str.charAt(i)=='A'||str.charAt(i)=='B'|| str.charAt(i)=='C') {
                    str=str.replace(str.charAt(i),'2');
                    sum+=str.charAt(i);
                }

                else if(str.charAt(i)=='D' || str.charAt(i)=='E' || str.charAt(i)=='F') {
                    str=str.replace(str.charAt(i),'3');
                    sum+=str.charAt(i);
                }

                else if(str.charAt(i)=='G'||str.charAt(i)=='H'||str.charAt(i)=='I') {
                    str=str.replace(str.charAt(i),'4');
                    sum+=str.charAt(i);
                }

                else if(str.charAt(i)=='J'||str.charAt(i)=='K'||str.charAt(i)=='L') {
                    str=str.replace(str.charAt(i),'5');
                    sum+=str.charAt(i);
                }

                else if(str.charAt(i)=='M'||str.charAt(i)=='N'||str.charAt(i)=='O') {
                    str=str.replace(str.charAt(i),'6');
                    sum+=str.charAt(i);
                }

                else if(str.charAt(i)=='P'||str.charAt(i)=='Q'||str.charAt(i)=='R'||str.charAt(i)=='S') {
                    str=str.replace(str.charAt(i),'7');
                    sum+=str.charAt(i);
                }

                else if(str.charAt(i)=='T'||str.charAt(i)=='U'||str.charAt(i)=='V') {
                    str=str.replace(str.charAt(i),'8');
                    sum+=str.charAt(i);
                }

                else if(str.charAt(i)=='W'||str.charAt(i)=='X'||str.charAt(i)=='Y'||str.charAt(i)=='Z') {
                    str=str.replace(str.charAt(i),'9');
                    sum+=str.charAt(i);
                }

                else if(str.charAt(i)==']') {
                    str=str.replace(str.charAt(i),'0');
                    sum+=str.charAt(i);
                }
                else {
                    sum+=str.charAt(i);
                }
            }
            System.out.println(sum);
        }
        input.close();
    }
}