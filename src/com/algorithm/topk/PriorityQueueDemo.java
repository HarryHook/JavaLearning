package com.algorithm.topk;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {

        int[] array = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};
        PriorityQueue queue = new PriorityQueue();
        for(int i:array) {
            queue.offer(i);
        }
        System.out.println(queue);
    }
}
