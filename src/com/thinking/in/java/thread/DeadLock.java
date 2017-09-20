package com.thinking.in.java.thread;

/*
public class DeadLock {
    public static void main(String[] args) {
        // flag=1，占有对象o1，等待对象o2
        // flag=2，占有对象o2，等待对象o1
        ThreadDemo demo1 = new ThreadDemo();
        demo1.flag = 1;
        ThreadDemo demo2 = new ThreadDemo();
        demo2.flag = 2;

        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo2);
        t1.start();
        t2.start();
    }
}
*/

public class DeadLock implements Runnable {
    // flag=1，占有对象o1，等待对象o1
    // flag=2，占有对象o2，等待对象o2
    public int flag;
    // 定义两个Object对象，模拟两个线程占有的资源
    public static Object o1 = new Object();
    public static Object o2 = new Object();

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        deadLock1.flag = 1;
        deadLock2.flag = 2;
        Thread thread1 = new Thread(deadLock1);
        Thread thread2 = new Thread(deadLock2);
        thread1.start();
        thread2.start();
    }

    public void run() {
        System.out.println("flag: " + flag);
        // deadLock2占用资源o1，准备获取资源o2
        if (flag == 1) {
            synchronized (o1) {
                try {
                    System.out.println("o1 sleep");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("执行不到o1中的o2");
                }
            }

        } else if (flag == 2) {  // deadLock1占用资源o2，准备获取资源o1
            synchronized (o2) {
                try {
                    System.out.println("o2 sleep");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("o2中的o1");
                }
            }
        }
    }
}

class ThreadDemo implements Runnable {
    Object obj1 = new Object();
    Object obj2 = new Object();

    int flag;

    @Override
    public void run() {
        if (flag == 1) {
            //定义为：代码块1
            while (true) {
                synchronized (obj1) {    //objA锁
                    System.out.println("if objA----");
                    synchronized (obj2) {  //objB锁
                        System.out.println("if objB----");
                    }
                }
            }

        } else if (flag == 2) {
            // 定义为：代码块 2
            while (true) {
                synchronized (obj2) {   //objB锁
                    System.out.println("else objB----");
                    synchronized (obj1) {  //objA锁
                        System.out.println("else objA----");
                    }
                }
            }


        }

    }
}
