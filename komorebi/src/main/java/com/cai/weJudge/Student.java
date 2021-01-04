package com.cai.weJudge;

import java.util.Scanner;

public class Student {
    private int[] scores;
    private String name;

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public String getName() {
        return name;
    }


    public Student(String name, int[] scores) {
        this.name = name;
        this.scores = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            this.scores[i]=scores[i];
        }
    }

    public double getSum() {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum+=scores[i];
        }
        return sum;
    }

    public double getAverage() {
        double av =0;
        for (int i = 0; i < scores.length; i++) {
            av+=scores[i];
        }
        av/=scores.length;
        return av;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            // 学生数和科目数
            int numberOfStudent = input.nextInt();
            int numberOfCourse = input.nextInt();
            Student[] stu = new Student[numberOfStudent];
            String name;
            int[] scores = new int[numberOfCourse];
            // 构建同学和每个课的成绩
            for (int i = 0; i < numberOfStudent; i++) {
                name = input.next();
                for (int j = 0; j < numberOfCourse; j++) {
                    scores[j] = input.nextInt();

                }
                stu[i] = new Student(name, scores);// 注意引用问题

            }
            // 按学生输出学生的总分和平均分
            for (int i = 0; i < stu.length; i++) {
                System.out.printf("%s %.2f %.2f\n", stu[i].getName(),
                        stu[i].getSum(), stu[i].getAverage());

            }
        }
        input.close();

    }
}
