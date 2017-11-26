package com.thinking.in.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    public static <T> List<T> makeList(T... args) {
        List<T> res = new ArrayList<>();
        for (T item : args) {
            res.add(item);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        List<Integer> li = makeList(1, 2, 3, 4, 5, 6);
        System.out.println(li);
        ls = makeList("ABCDEFGHIGKLMN".split(""));
        System.out.println(ls);
    }
}
