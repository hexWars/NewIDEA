package com.cai.high.other;

public class Statement {
    public static void main(String[] args) {
        String[][] str = {
                {"小明", "早上", "在厕所", "吃泡面"},
                {"猩猩", "昨天", "在雨林里", "敲代码"},
                {"外星人", "刚刚", "在我的肚子里", "做实验"},
                {"一个男人","半夜","在床上","搓炉石"},
                {"一只猫","中午","在我的头上","吃老鼠"}
        };
        for (int i = 0; i < 10; i++) {
            System.out.println(str[(int)(Math.random()*5)][0]+
                    str[(int)(Math.random()*5)][1]+
                    str[(int)(Math.random()*5)][2]+
                    str[(int)(Math.random()*5)][3]);
        }
    }
}
