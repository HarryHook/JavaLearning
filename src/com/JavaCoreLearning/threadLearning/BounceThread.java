package com.JavaCoreLearning.threadLearning;

import java.awt.Component;

import javax.swing.JFrame;



public class BounceThread {
    public static void main(String[] args) {
	JFrame frame = new BounceFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
}

class BallRunnable implements Runnable {
    private Component component;
    public static final int DELAY = 5;
    public static final int STEPS = 1000;
    private Ball ball;
    
    public BallRunnable(Ball ball, Component component) {
	this.ball = ball;
	this.component = component;
    }
    public void run() {
	try {
	  
	    for(int i=1; i<=STEPS; i++) {
	
		ball.move(component.getBounds());
		component.repaint();
		
		Thread.sleep(DELAY);
	    }
	} catch(InterruptedException e) {
	    e.printStackTrace();
	}
    }
   
}
