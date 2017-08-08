package com.imooc.threadlearning;

public class Actor extends Thread {
    public void run() {
	System.out.println(Thread.currentThread().getName() + ": I am a actor");
	int count = 0;
	boolean keepRunning = true;
	while (keepRunning) {
	    System.out.println(Thread.currentThread().getName() + ": 登台演出" + ++count + "次");
	    if (count == 100) {
		keepRunning = false;
	    }
	    if (count % 10 == 0) {
		try {
		    sleep(1000);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
	System.out.println(Thread.currentThread().getName() + "的演出结束！");
    }

    public static void main(String[] args) {
	Thread actor = new Thread(new Actor());
	Thread actress = new Thread(new Actress());
	actress.setName("Ms.Cherry");
	actor.setName("Mr.Hook");
	actress.start();
	actor.start();
    }
}
class Actress implements Runnable {
    public void run() {
	System.out.println(Thread.currentThread().getName() + ": I am a actress");
	int count = 0;
	boolean keepRunning = true;
	while (keepRunning) {
	    System.out.println(Thread.currentThread().getName() + ": 登台演出" + ++count + "次");
	    if (count == 100) {
		keepRunning = false;
	    }
	    if (count % 10 == 0) {
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
	System.out.println(Thread.currentThread().getName() + "的演出结束！");
    }

}
