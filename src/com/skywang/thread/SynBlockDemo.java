package com.skywang.thread;

public class SynBlockDemo {
    public synchronized void synMethod() {
        for (long i = 0; i < 1000000000; i++) {
            ;
        }
    }

    public void synBlock() {
        synchronized (this) {
            for (long i = 0; i < 1000000000; i++) {
                ;
            }
        }
    }

    public static void main(String[] args) {
        SynBlockDemo demo = new SynBlockDemo();
        long start = System.currentTimeMillis();
        demo.synMethod();
        long diff = System.currentTimeMillis() - start;

        System.out.println("synMethod: " + diff + "ms");

        start = System.currentTimeMillis();
        demo.synBlock();
        diff = System.currentTimeMillis() - start;
        System.out.println("synBlcok: " + diff + "ms");
    }
}
