package com.skywang.thread;

class ThreadD extends Thread {
    public ThreadD(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + "(" + i + ") " + " isDaemon? " + this.isDaemon());
        }
    }
}

class ThreadDaemon extends Thread {
    public ThreadDaemon(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(this.getName() + "(" + i + ") " + " isDaemon? " + this.isDaemon());
        }
    }
}

public class DaemonDemo {
    public static void main(String[] args) {
        ThreadD t1 = new ThreadD("t1");
        ThreadD t2 = new ThreadD("t2");
        t2.setDaemon(true);
        t1.start();
        t2.start();
        t1.setPriority(1);
        t2.setPriority(10);


    }
}
