package com.thinking.in.java.thread;

public class BasicThread {

    public static void main(String[] args) {
//	Thread thread = new Thread(new LiftOff());
//	thread.start();
//	System.out.println("wating for liftOff");
	
	for(int i=0; i< 5; i++) {
	    new Thread(new LiftOff()).start();
	}
	System.out.println("wating for liftOff");
    }

}
