package com.cai.high.genericity;

/**
 * @author Cai
 * @time 2020-09-28-10:27
 */

/*
* 泛型,简单来讲就是规定类型,在集合中用的比较多,但我们也可以用泛型定义类或者接口
* 泛型类,可以看成是有类型的类
* 这个类型(泛型形参)可以是自定义的,可以是String,可以是Integer,但是不能是int,double等基本数据类型,有时候,自定义的类型可能是无意义的
* */
//定义Apple时使用了泛型声明
public class Apple<T> {
    //使用T定义实例变量
    private T info;
    public Apple(){}
    //下面使用T类型来定义构造器
    public Apple(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        //由于传给T形参的是String,所以构造器参数只能是String
        Apple<String> a1 = new Apple<>("苹果");
        System.out.println(a1.getInfo());
        //由于传给T形参的是Double,所以构造器参数只能是Double或double
        Apple<Double> a2 = new Apple<>(5.23);
        System.out.println(a2.getInfo());
    }
}
