package com.skywang.thread;

class ThreadWaitMills extends Thread {
    public ThreadWaitMills(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(currentThread().getName() + " run");
        while (true) ;
    }
}

public class WaitMillsTest {
    public static void main(String[] args) {
        ThreadWaitMills t1 = new ThreadWaitMills("t1");
        synchronized (t1) {
            try {
                System.out.println(Thread.currentThread().getName() + " start");
                t1.start();
                System.out.println(Thread.currentThread().getName() + " wait(1000)");

                t1.wait(1000);
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
