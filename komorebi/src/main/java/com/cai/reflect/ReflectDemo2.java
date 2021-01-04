package com.cai.reflect;

import java.lang.reflect.Field;

/**
 * @author Cai
 * @time 2020-10-14-23:23
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------");
        Field a = personClass.getField("a");
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //改变值
        a.set(p,"jiangjing");
        System.out.println(p);

        System.out.println("===============");
        //不考虑修饰符
        Field[] declardFields = personClass.getDeclaredFields();
        for (Field declardField : declardFields) {
            System.out.println(declardField);
        }

        Field d = personClass.getDeclaredField("d");
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);//直接访问法会报错,要加上上一行f
        System.out.println(value2);
    }
}
