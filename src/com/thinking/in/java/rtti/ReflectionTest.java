package com.thinking.in.java.rtti;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c = Methods.class;
        Object obj = c.newInstance();   //实例化
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println();

        Method[] method = c.getMethods();
        for (Method m : method) {
            System.out.println(m);
        }
        System.out.println();
        Method m = c.getMethod("add", int.class, int.class);
        System.out.println(m);
//        Object res = m.invoke(m, 1, 2);
//        System.out.println("res" + res);
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        Field[] field = c.getFields();
        for (Field f : field) {
            System.out.println(f);
        }
        Constructor constructor = c.getDeclaredConstructor();
        Methods m1 = (Methods) constructor.newInstance();
        System.out.println("默认构造函数 " + m1);

        Constructor constructor1 = c.getDeclaredConstructor(new Class[]{int.class});
        Methods m2 = (Methods) constructor1.newInstance(new Object[]{1});
        System.out.println("带参构造函数 " + m2);

    }
}

class Methods {
    private int count = 1;

    public Methods() {

    }

    public Methods(int count) {
        this.count = count;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

}
