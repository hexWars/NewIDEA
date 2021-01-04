package com.cai.reflect;

import java.lang.reflect.Method;

/**
 * @author Cai
 * @time 2020-10-14-23:23
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        Method eat_method = personClass.getMethod("eat");
        Person p =new Person();
        //执行
        eat_method.invoke(p);


        Method eat_method2 = personClass.getMethod("eat",String.class);
        //执行
        eat_method2.invoke(p,"ccc");

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
