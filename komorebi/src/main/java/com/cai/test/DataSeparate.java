package com.cai.test;

import java.util.LinkedList;

/**
 * @author: Cai
 * @date: 2020/11/16 13:30
 * @description:
 */
public class DataSeparate {

}

class Box {
    private final int MAX_SIZE = 5;//仓储最大容量
    private LinkedList<Object> list = new LinkedList<Object>();//仓储容器

    //增加公共资源
    public void increase() {
        synchronized (list) {
            while (list.size() > MAX_SIZE) {
                System.out.println("...现在箱子中苹果的数量：" + list.size() + "箱子中的苹果超过5个,暂时不能执行任务！");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("...往箱子中放入1个苹果,现在箱子中苹果的数量：" + list.size());
            list.notifyAll();
        }
    }

    //减少公共资源
    public void decrease() {
        synchronized (list) {
            while (list.size() < 1) {
                System.out.println("现在箱子中苹果的数量：" + list.size() + "箱子中苹果数量不足1个,暂时不能执行生产任务!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();//从集合中移除
            System.out.println("从箱子中取出1个苹果，现在箱子中苹果的数量：" + list.size());
            list.notifyAll();
        }
    }
}

//生产者
class Producer implements Runnable {
    private Box box;

    Producer(Box box) {
        this.box = box;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.increase();
        }
    }
}

//消费者
class Consumer implements Runnable {
    private Box box;

    public Consumer(Box box) {
        this.box = box;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.decrease();
        }
    }
}

class BoxAppleThread {
    public static void main(String[] args) {
        //创建资源对象
        Box box = new Box();
        //创建线程任务对象
        Producer pro = new Producer(box);
        Consumer con = new Consumer(box);
        //创建线程
        new Thread(pro).start();
        new Thread(con).start();
        new Thread(pro).start();
        new Thread(con).start();
    }
}