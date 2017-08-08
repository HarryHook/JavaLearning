package com.imooc.threadlearning.base;

public class ArmyRunnable implements Runnable {

    volatile boolean keepRunning = true;
    //JMM happens-before
    @Override
    public void run() {
	while (keepRunning) {
	    for (int i = 0; i < 5; i++) {
		System.out.println(Thread.currentThread().getName() + "进攻：[" + i + "]次");
		Thread.yield();
	    }
	}
	System.out.println(Thread.currentThread().getName() + "战斗结束");
    }

}
