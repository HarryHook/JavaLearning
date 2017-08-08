package com.imooc.threadlearning.base;

public class Stage extends Thread {
    @Override
    public void run() {
	ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
	ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
	Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "sui");
	Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "revolt");
	armyOfSuiDynasty.start();
	armyOfRevolt.start();

	try {
	    Thread.sleep(100);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	System.out.println("杀出一个程咬金");
	Thread Mr_chen = new KeyPersonThread();
	Mr_chen.setName("程咬金");
	System.out.println("程咬金能结束战斗");
	
	armyTaskOfSuiDynasty.keepRunning = false;
	armyTaskOfRevolt.keepRunning = false;
	
	try {
	    Thread.sleep(2000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	Mr_chen.start();
	try {
	    Mr_chen.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.out.println("Over");
    }

    public static void main(String[] args) {
	new Stage().start();
    }
}
