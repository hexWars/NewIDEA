package com.cai.reflect;

import java.lang.reflect.Constructor;

/**
 * @author Cai
 * @time 2020-10-14-23:23
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建对象
        Object person = constructor.newInstance("asdf",343);
        System.out.println(person);
    }
}
