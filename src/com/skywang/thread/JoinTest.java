package com.skywang.thread;

public class JoinTest {
    public static void main(String[] args) {
        try {
            ThreadJoin t1 = new ThreadJoin("t1");
            t1.start();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished!");


    }

    static class ThreadJoin extends Thread {
        public ThreadJoin(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.printf("%s start\n", this.getName());

            for (int i = 0; i < 10000000; i++) ;
            System.out.println(currentThread().getName() + " finished!");

        }

    }
}
