package com.skywang.thread;

class QueueBuffer {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        if (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        if (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer1 implements Runnable {

    private QueueBuffer q;

    Producer1(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }

}

class Consumer1 implements Runnable {

    private QueueBuffer q;

    Consumer1(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        QueueBuffer q = new QueueBuffer();
        new Producer1(q);
        new Consumer1(q);
        System.out.println("Press Control-C to stop.");
    }

}