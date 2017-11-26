package com.skywang.thread;

public class RunThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();

    }
}
