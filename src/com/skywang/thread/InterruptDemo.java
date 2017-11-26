package com.skywang.thread;

class ThreadInterrupt extends Thread {
    private volatile boolean flag = true;

    public void stopTask() {
        flag = false;
    }

    public ThreadInterrupt(String name) {
        super(name);
    }

    @Override
    public void run() {

        int i = 0;


            try {
                System.out.println("try-->start=" + isInterrupted());
                Thread.sleep(100);
                i++;
                System.out.println(currentThread().getName() + "[" + this.getState() + "] loop: " + i);
                System.out.println("try-->start2=" + isInterrupted());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");

            }
        System.out.println("end--->try_catch=" + isInterrupted());
    }
}

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt t1 = new ThreadInterrupt("t1");
        System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");
        ThreadInterrupt t2 = new ThreadInterrupt("t2");
        t1.start();
        System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");
//        t2.start();
//        System.out.println(t2.getName() + " (" + t2.getState() + ") is started.");
        // 主线程休眠300ms，然后主线程给t1发“中断”指令。
        Thread.sleep(300);
        t1.interrupt();
//        t1.stopTask();
        Thread.sleep(300);
        System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
    }


}
