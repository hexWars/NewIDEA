package com.cai.test;

/**
 * @author: Cai
 * @date: 2020/12/30 8:12
 * @description:
 */
public class Fuxi {

}

class RunnableTread implements Runnable {
    public void run() {
        //...
    }

    public static void main(String[] arg) {
        RunnableTread run = new RunnableTread();
        new Thread(run, " ").start();
    }
}

//public class DrawThread extends Thread {
//    public void run() {
//        synchronized (account) {
//            if (account.getBalance() >= drawAmount) {
//                System.out.println("取钱成功");
//            } else
//                System.out.println("取钱失败");
//        }
//    }
//}