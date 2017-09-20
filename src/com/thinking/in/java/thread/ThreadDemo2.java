package com.thinking.in.java.thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread2 t = new Thread2();

        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}

class Thread2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {

        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售票：" + ticket--);
        }
    }
}
