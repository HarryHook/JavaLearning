package com.skywang.thread;

class MyThread implements Runnable {
    private int ticket = 100;

    @Override
    public synchronized void run() {

        while (true) {
            synchronized (this) {
                if (ticket <= 0) {
                    System.out.println("Thread:" + Thread.currentThread().getName() + " exit for loop,not enough tickets.");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " sales the " + ticket + " ticket.");
                ticket--;
            }
            try {
                /*
                sleep用的也不对，sleep让线程休眠一段时间，但是锁根本没有释放掉，别的线程还是没法拿到锁，也就没办法执行。
                应该用this.wait(10)就对了。
                或者使用公平的重入锁，也是可以的。
                 */
                this.wait(10);
            } catch (InterruptedException ie) {
                System.out.println("Thread:" + Thread.currentThread().getName() + " catch exception.");
            }
        }
    }

}
