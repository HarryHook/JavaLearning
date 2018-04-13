package com.nowcoder.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaDemo2 {
    /*
    左侧： lambda表达式的参数列表
    右侧：lambda表达式的所需执行的功能，即lambda体
     */

    //语法格式一： 无参，无返回值    ()-> 实现

    @Test
    public void test1() {
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        //等价于
        r1.run();
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda!!");
            }
        };
        r2.run();
    }

    //语法格式二： 有参，无返回值，如果只有一个参数，()可以省略不写
    //(x)-> System.out.println(x);
    @Test
    public void test2() {
        Consumer con = (x) -> System.out.println(x);
        con.accept("I will get new offer!");
    }

    //语法格式三： 有2个参数，lambda体中有多条语句,lambda体用{}括起来
    @Test
    public void test3() {
        Comparator<Integer> cmp = (x, y) -> {
            System.out.println("");
            return Integer.compare(x, y);
        };
    }

    //语法格式四： 有2个参数，lambda体中只有一条语句， {}、return可以省略
    @Test
    public void test4() {
        Comparator<Integer> cmp = (x, y) -> Integer.compare(x, y);
    }

    //语法格式四： lambda表达式参数的数据类型可以不写，JVM可以根据上下文来推断，如果要写的的写
    @Test
    public void test5() {
        Comparator<Integer> cmp = (Integer x, Integer y) -> Integer.compare(x, y);
    }

    //函数式接口实例
    @Test
    public void test6() {
        String str = operation("ILOVEbbb", s -> s.toUpperCase());
        System.out.println(str);
        String str1 = operation("ILOVEbbb", s -> s.substring(1, 5));
        System.out.println(str1);

    }

    public String operation(String str, MyInterface mf) {
        return mf.getValue(str);
    }

    @Test
    public void test7() {
        long res = operation1(100000000L, 10000000L, (x, y) -> x + y);
        System.out.println(res);
        long res1 = operation1(300L, 200L, (x, y) -> x * y);
        System.out.println(res1);
    }

    public Long operation1(Long num1, Long num2, MyFunc2<Long, Long> mf) {
        return mf.getValue(num1, num2);
    }
}
