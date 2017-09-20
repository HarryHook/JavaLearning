package com.thinking.in.java.thread;

public class ThreadDemo3 {
    public static void main(String args[]) {
        DemoRunnable dr = new DemoRunnable();
        Thread t1 = new Thread(dr);
        Thread t2 = new Thread(dr);
        Thread t3 = new Thread(dr);
        Thread t4 = new Thread(dr);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class DemoRunnable implements Runnable {
    private int ticket = 100;
    Object obj = new Object();  //相当于传入的对象锁

    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                    }
                    System.out.println(Thread.currentThread().getName() + "--售票：" + ticket--);
                } else {
                    System.exit(1);
                }
            }
        }
    }
}