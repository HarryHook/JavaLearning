package com.skywang.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Counter {
    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
    }
}

class CounterThread extends Thread {

    protected Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.add(i);
            System.out.println(Thread.currentThread().getName()+" ");
        }
    }
}
public class Example {

    public static void main(String[] args){
        Counter counterA = new Counter();
        Counter counterB = new Counter();
        Thread  threadA = new CounterThread(counterA);
        Thread  threadB = new CounterThread(counterB);

        threadA.start();
        threadB.start();
        ExecutorService pool = Executors.newFixedThreadPool(2);
    }
}