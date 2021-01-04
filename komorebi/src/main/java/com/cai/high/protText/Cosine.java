package com.cai.high.protText;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Cai
 * @create 2020-09-27-21:35
 */
public class Cosine implements Similarity{
    public static double YUZHI = 0.001 ;
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
        int size = 0 , size2 = 0 ;
        if ( cb1 != null && ( size = cb1.length ) > 0 && cb2 != null && ( size2 = cb2.length ) > 0 ) {

            Map<Double, double[]> T = new HashMap<Double, double[]>();

            //T1和T2的并集T
            double index = -99999 ;
            for ( int i = 0 ; i < size ; i++ ) {
                index = cb1[i] ;
                if( index != -99999){
                    double[] c = T.get(index);
                    c = new double[2];
                    c[0] = 1;  //T1的语义分数Ci
                    c[1] = YUZHI;//T2的语义分数Ci
                    T.put( index, c );
                }
            }

            for ( int i = 0; i < size2 ; i++ ) {
                index = cb1[i] ;
                if( index != -99999 ){
                    double[] c = T.get( index );
                    if( c != null && c.length == 2 ){
                        c[1] = 1; //T2中也存在，T2的语义分数=1
                    }else {
                        c = new double[2];
                        c[0] = YUZHI; //T1的语义分数Ci
                        c[1] = 1; //T2的语义分数Ci
                        T.put( index , c );
                    }
                }
            }

            //开始计算，百分比
            Iterator<Double> it = T.keySet().iterator();
            double s1 = 0 , s2 = 0, Ssum = 0;  //S1、S2
            while( it.hasNext() ){
                double[] c = T.get( it.next() );
                Ssum += c[0]*c[1];
                s1 += c[0]*c[0];
                s2 += c[1]*c[1];
            }
            //百分比
            return Ssum / Math.sqrt( s1*s2 );
        } else {
            try {
                throw new Exception("相似度计算工具类传入参数有问题！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }


}
