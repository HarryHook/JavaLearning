package com.skywang.thread;

class ThreadSleep extends Thread {
    public ThreadSleep(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(currentThread().getName() + "[" + this.getPriority() + "] : " + i);
                    if (i % 3 == 0) {
                        sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

public class SleepTest {
    static Object obj = new Object();

    public static void main(String[] args) {
        ThreadS t1 = new ThreadS();
//        ThreadS t2 = new ThreadS("t2");
//        ThreadS t3 = new ThreadS("t3");
//        ThreadSleep t1 = new ThreadSleep("t1");
//        ThreadSleep t2 = new ThreadSleep("t2");
//        ThreadSleep t3 = new ThreadSleep("t3");
        t1.setName("t1");
        t1.start();
//        t2.start();
//        t3.start();
    }

    static class ThreadS extends Thread {
        public ThreadS() {
            System.out.println(currentThread().getName() +" " + this.getName());
        }

        @Override
        public void run() {

            //为什么一次只有一个线程休眠
            try {
                Thread.sleep(1000);
                System.out.println(currentThread().getName() +" " + this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}