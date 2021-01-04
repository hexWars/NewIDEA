package com.cai.high.protText;

import java.util.Scanner;

/**
 * @author Cai
 * @creat                                                         6666                                                       6e 2020-09-27-20:17
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Data data = new Data();
        data.setData();
        System.out.println("以下是皮尔逊系数算法");
        Pearson p = new Pearson();
        p.group(data.getData());
        System.out.println("以下是欧几里得算法");
        Euclidean e = new Euclidean();
        e.group(data.getData());
        System.out.println("以下是余弦相似度算法");
        Cosine c = new Cosine();
        c.group(data.getData());
    }
}
