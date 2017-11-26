package com.skywang.thread;

public class SynchronizedDemo {
    public static void main(String[] args) {
        final Count count = new Count();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                count.synMethod();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                count.nonSynMethod();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
