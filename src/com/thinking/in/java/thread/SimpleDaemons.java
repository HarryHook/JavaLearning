package com.thinking.in.java.thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

    public void run() {
	try {
	    while (true) {
		TimeUnit.MILLISECONDS.sleep(1000);
		System.out.print(Thread.currentThread() + " " + this);
	    }
	} catch (Exception e) {
	    e.printStackTrace();

	}
    }

    public static void main(String[] args) throws InterruptedException {
	for (int i = 0; i < 10; i++) {
	    Thread daemon = new Thread(new SimpleDaemons());
	    daemon.setDaemon(true);
	    daemon.start();
	    System.out.println("All daemons started");
	    TimeUnit.MILLISECONDS.sleep(1000);
	}
    }
}
