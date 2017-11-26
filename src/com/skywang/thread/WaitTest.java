package com.skywang.thread;

class ThreadDemo extends Thread {
    public ThreadDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(currentThread().getName() + " call notify()");
            notify();
        }

    }
}

public class WaitTest {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("t1");
        synchronized (t1) {
            try {
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                System.out.println(Thread.currentThread().getName() + " wait");
                /*
                t1.wait()应该是让“线程t1”等待；但是，为什么却是让“主线程main”等待了呢？
                虽然t1.wait()是通过“线程t1”调用的wait()方法，但是调用t1.wait()的地方是在“主线程main”中。
                而主线程必须是“当前线程”，也就是运行状态，才可以执行t1.wait()。
                所以，此时的“当前线程”是“主线程main”！因此，t1.wait()是让“主线程”等待，而不是“线程t1”！
                 */
                t1.wait();
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
