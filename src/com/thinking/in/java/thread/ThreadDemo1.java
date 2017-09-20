package com.thinking.in.java.thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread t2 = new Thread1();
        t1.start();
        t2.start();
        for (int i = 0; i < 50; i++) {
            System.out.println("main ...i= " + i);
        }
    }

}

class Thread1 extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 500; i++) {
            System.out.println("thread: " + i + " " + threadName);
        }
    }
}
