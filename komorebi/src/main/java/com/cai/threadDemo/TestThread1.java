package com.cai.threadDemo;

/**
 * @author: Cai
 * @date: 2020/12/9 14:25
 * @description:
 */

//创建线程方式一:继承Thread类,重写run()方法,调用start开启线程
// 线程开启不一定立即执行,有CPU调度执行
public class TestThread1 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 5; i++) {
            System.out.println("hhh");
        }
    }

    public static void main(String[] args) {
        //main线程,主线程

        //创建线程对象并调用方法start
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("kkk");
        }
    }
}
