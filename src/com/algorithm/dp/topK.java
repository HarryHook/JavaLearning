package com.algorithm.dp;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class topK {
    public static void main(String[] agrs) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(5, cmp);
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            queue.add(rand.nextInt(100));
        }
        for (int i = 0; i < 10; i++) {
            Integer num = queue.poll();
            System.out.print(num + " ");
        }
//        Iterator<Integer> iter = queue.iterator();
//        while (iter.hasNext()) {
//            Integer num = iter.next();
//            System.out.print(num + " ");
//        }
    }
}
