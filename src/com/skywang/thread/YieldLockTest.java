package com.skywang.thread;

public class YieldLockTest {
    static Object obj = new Object();

    public static void main(String[] args) {
        ThreadY t1 = new ThreadY("t1");
        ThreadY t2 = new ThreadY("t2");
        t1.start();
        t2.start();
    }

    static class ThreadY extends Thread {
        public ThreadY(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 100; i++) {
                    System.out.println(currentThread().getName() + "[" + this.getPriority() + "] : " + i);
                    if (i % 3 == 0) {
                    /*
                     yield()并不会释放线程的锁,不管其他线程的优先级如何
                     */
                        yield();
                    }
                }
            }
        }
    }
}
