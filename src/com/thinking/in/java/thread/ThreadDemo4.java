package com.thinking.in.java.thread;

public class ThreadDemo4 {
    public static void main(String args[]) {
        MyRunnable dr = new MyRunnable();
        StaMyRunnable smr = new StaMyRunnable();
        Thread t1 = new Thread(smr);
        Thread t2 = new Thread(smr);
        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable {
    private static int sum = 0;

    public void run() {
        for (int i = 0; i < 3; i++) {
            add(100);
        }
    }

    private synchronized void add(int m) {
        sum += m;
        System.out.println(Thread.currentThread().getName() + "存储：" + sum);
    }
}

class StaMyRunnable implements Runnable {
    private static int sum = 0;

    public void run() {
        for (int i = 0; i < 3; i++) {
            add(100);
        }
    }

    private static synchronized void add(int m) {
        sum += m;
        System.out.println(Thread.currentThread().getName() + "存储：" + sum);
    }
}