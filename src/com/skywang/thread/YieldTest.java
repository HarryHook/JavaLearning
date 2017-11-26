package com.skywang.thread;

class ThreadYield extends Thread {
    public ThreadYield(String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println(currentThread().getName() + "[" + this.getPriority() + "] : " + i);
            if (i % 3 == 0) {
                /*
                yield()会让当前线程从运行态进入就绪状态，让线程优先级更高的执行
                如果没有优先级更高的线程，则执行线程优先级相同的线程，有可能会继续执行当前线程
                 */
                yield();
            }
        }
    }
}

public class YieldTest {
    public static void main(String[] args) {

        ThreadYield t1 = new ThreadYield("t1");
        ThreadYield t2 = new ThreadYield("t2");
        t1.setPriority(6);
        t1.start();
        t2.start();
    }


}
