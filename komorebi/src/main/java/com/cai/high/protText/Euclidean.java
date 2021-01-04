package com.cai.high.protText;

/**
 * @author Cai
 * @create 2020-09-27-21:32
 */
public class Euclidean implements Similarity{
    double cbEnd[] = new double[24];

    @Override
    public void group(double[][] cb) {
        int cut = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 5; j++) {
                cbEnd[cut++] = treate(cb[i],cb[j]);
                System.out.println(i+" "+j+" "+cbEnd[cut-1]);
            }
        }
    }

    @Override
    public double treate(double[] cb1, double[] cb2) {
        double distance = 0;

        if (cb1.length == cb2.length) {
            for (int i = 0; i < cb1.length; i++) {
                double temp = Math.pow((cb1[i] - cb2[i]), 2);
                distance += temp;
            }
            distance = Math.sqrt(distance);
        }
        return distance;
    }

}
