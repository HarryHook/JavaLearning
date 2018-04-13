package com.nowcoder.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaDemo3 {
    //1.Conuser<T>接口
    @Test
    public void test1() {
        consume(1000, money -> System.out.println("消费：" + money + "元"));
    }

    public void consume(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    //2.供给型接口, 产生10个100以内的整数集合
    @Test
    public void test2() {
        List<Integer> numList = supply(10, () -> (int) (Math.random() * 100));
        for (int num : numList) {
            System.out.print(num + " ");
        }
    }

    public List<Integer> supply(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    //3.Function<T, R>: 函数型接口
    //      R apply(T t);
    @Test
    public void test3() {
        String str = apply("IwillbeStrong", s -> s.toUpperCase());
        System.out.println(str);
        String str1 = apply("\t\t   asdasd", s -> s.trim());
        System.out.println(str1);
    }

    public String apply(String str, Function<String, String> function) {
        return function.apply(str);
    }

    //4.Predicate<T> : 断言型接口， 用于作判断
    //boolean test(T t);
    //需求：返回满足要求的字符串的集合
    @Test
    public void test4() {
        List<String> strList = Arrays.asList("hello", "world", "adc", "car", "app");
        List<String> res = filterStr(strList, s -> s.length() > 3);
        System.out.println(res);

    }

    public List<String> filterStr(List<String> strings, Predicate<String> predicate) {
        List<String> strList = new ArrayList<>();
        for (String str : strings) {
            if (predicate.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

}
