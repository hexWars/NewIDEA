package com.cai.high.car;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Auto bb = new BlueBird(4,"red",
                40,40,100,2);
        Auto lr = new LandRover(4,"blue",
                50,40,120,2,1);
        System.out.println("1.BlueBird加速\n2.BlueBird减速\n3.BlueBird停车\n" +
                "4.LandRover加速\n5.LandRover减速\n6.LandRoverLandRover停车\n");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int x = in.nextInt();
            switch (x){
                case 1:
                    System.out.println("加速多少公里呢");
                    bb.accelerate(in.nextInt());
                    System.out.println("不好意思我不会算时间,你想换一下飞机吗");
                    break;
                case 2:
                    System.out.println("减速多少公里呢");
                    bb.decelerate(in.nextInt());
                    System.out.println("不好意思我不会算时间,想变慢?吃多点");
                    break;
                case 3:
                    bb.stop();
                    System.out.println("想提速到100km/h吗\n不好意思,遥遥无期");
                    break;
                case 4:
                    System.out.println("加速多少公里呢");
                    lr.accelerate(in.nextInt());
                    System.out.println("不好意思我不会算时间,哈哈哈,快快继续不要停");
                    break;
                case 5:
                    System.out.println("减速多少公里呢");
                    lr.decelerate(in.nextInt());
                    System.out.println("不好意思我不会算时间,来吧,再慢一点");
                    break;
                case 6:
                    lr.stop();
                    System.out.println("想提速到100km/h吗\n不好意思,遥遥无期");
                    break;
            }
        }
    }
}
