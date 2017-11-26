package com.skywang.thread;

class ThreadTest extends Thread {
    public ThreadTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(currentThread().getName() + " is running!");
    }
}

public class StartMethodTest {
    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("t1");
        t1.run();
        t1.start();
    }
}
