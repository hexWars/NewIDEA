package com.cai.weJudge;

import java.util.Scanner;

public class GameNumber {
    private int max;
    private int min;
    private int featureValue;

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setFeatureValue(int featureValue) {
        this.featureValue = featureValue;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getFeatureValue() {
        return featureValue;
    }

    public GameNumber(int a, int b, int feature) {
        if (a > b) {
            this.max = a;
            this.min = b;
        } else {
            this.max = b;
            this.min = a;
        }
        this.featureValue = feature;
    }

    public String listAllFeatureNumbers() {
        if (featureValue == 0) {
            String va = "(";
            int cut=0;
            for (int i = min; i <= max; i++) {
                if (i%10==0){
                    if (cut==0){
                        va=va+""+i;
                    }else {
                        va = va + "," + i;
                    }
                    cut++;
                }
            }
            va=va+")";
            return va;
        }
        String va = "(";
        int cut = 0;
        for (int i = min; i <= max; i++) {
//            if (i < 0) i = 0;
            if (i % 10 == featureValue||i % featureValue == 0) {
                if (cut == 0) {
                    va = va + i + "";
                } else {
                    va = va + "," + i;
                }
                cut++;
            }
        }
        va = va + ")";
        return va;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int min = input.nextInt();
            int max = input.nextInt();
            int f = input.nextInt();
            GameNumber gn = new GameNumber(min, max, f);
            System.out.printf("%d-%d-%d\n", gn.getMin(), gn.getMax(), gn.getFeatureValue());
            System.out.println(gn.listAllFeatureNumbers());
        }

    }
}
