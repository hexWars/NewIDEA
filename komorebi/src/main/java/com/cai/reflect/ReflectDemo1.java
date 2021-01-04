package com.cai.reflect;

/**
 * @author Cai
 * @time 2020-10-12-21:27
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("com.cai.reflect.Person");
        System.out.println(c);
        Class c2 = Person.class;
        System.out.println(c2);
        Person p = new Person();
        Class c3 = p.getClass();
        System.out.println(c3);
    }
}
