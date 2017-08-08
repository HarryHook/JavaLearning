package com.JavaCoreLearning;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

public class TalkingClock {
    public TalkingClock(int interval, boolean beep) {
	this.interval = interval;
	this.beep = beep;
    }
    //anonymous inner class
    
    
    public void start() {
	class TimePrinter implements ActionListener {

		public void actionPerformed(ActionEvent event) {
	            Date now = new Date();
	            System.out.println("At the tone, the time is: " + now);
	            if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
		}
	}
	ActionListener listener = new TimePrinter();
	Timer t = new Timer(interval, listener);
	t.start();
    }
    
    
    private int interval;
    private boolean beep;
    
    /* Inner Class
    private class TimePrinter implements ActionListener {

	public void actionPerformed(ActionEvent event) {
            Date now = new Date();
            System.out.println("At the tone, the time is: " + now);
            if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
	}
    }
    */

}
