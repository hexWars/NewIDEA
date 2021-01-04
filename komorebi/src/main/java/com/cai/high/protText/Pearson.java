package com.cai.high.protText;

/**
 * @author Cai
 * @time  2020-09-27-21:23
 */
public class Pearson implements Similarity {
    private double[] xData;
    private double[] yData;
    private double xMeans;
    private double yMeans;
    private double numerator;
    private double denominator;
    private double pearsonCorrelationScore;
    double[] cbEnd = new double[24];

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
        xData = cb1;
        yData = cb2;
        xMeans = getMeans(xData);
        yMeans = getMeans(yData);
        numerator = generateNumerator();
        denominator = generateDenomiator();
        pearsonCorrelationScore = numerator / denominator;
        return pearsonCorrelationScore;
    }

    private double getMeans(double[] datas) {
        double sum = 0.0;
        for (int i = 0; i < datas.length; i++) {
            sum += datas[i];
        }
        return sum / datas.length;
    }
    private double generateNumerator() {
        double sum = 0.0;
        for (int i = 0; i < xData.length; i++) {
            sum += (xData[i] - xMeans) * (yData[i] - yMeans);
        }
        return sum;
    }
    private double generateDenomiator() {
        double xSum = 0.0;
        for (int i = 0; i < xData.length; i++) {
            xSum += (xData[i] - xMeans) * (xData[i] - xMeans);
        }

        double ySum = 0.0;
        for (int i = 0; i < yData.length; i++) {
            ySum += (yData[i] - yMeans) * (yData[i] - yMeans);
        }

        return Math.sqrt(xSum) * Math.sqrt(ySum);
    }
}
