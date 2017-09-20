package com.algorithm.mapset;

import java.util.*;

public class IterSet {
    public static void main(String[] args) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        TreeSet<Integer> set = new TreeSet<Integer>(cmp);
        set.add(5);
        set.add(10);
        set.add(3);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(11);

        Iterator<Integer> iter = set.descendingIterator();
        int i = 0;
        while ((iter.hasNext())) {
            Integer num = iter.next();
            System.out.print(num + " ");

        }

    }
}
