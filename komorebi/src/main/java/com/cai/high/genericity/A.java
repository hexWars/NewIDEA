package com.cai.high.genericity;

/**
 * @author Cai
 * @time 2020-10-19-18:40
 */
public class A extends Apple{
    public static void main(String[] args) {
        A aa = new A();
        aa.setInfo("hhh");
        aa.setInfo(4);
        System.out.println(aa.getInfo());
    }
}
