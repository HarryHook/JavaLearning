package com.thinking.in.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    public void run() {
	while(CountDown-- > 0) {
	    System.out.println(status());
	    try {
		TimeUnit.MILLISECONDS.sleep(1000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
    public static void main(String[] args) {
	ExecutorService exec = Executors.newCachedThreadPool();
	for(int i=0; i<5; i++) {
	    exec.execute(new SleepingTask());
	}
	exec.shutdown();
    }

}
