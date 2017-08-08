package com.JavaCoreLearning;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AnnoymousInnerClass {
    public static void main(String[] args) {
	TalkingClock1 clock = new TalkingClock1();
	clock.start(1000, true);
	JOptionPane.showMessageDialog(null, "Quit program?");
	System.exit(0);
    }
    
}
class TalkingClock1 {
    public void start(int interval, final boolean beep) {
	ActionListener listener = new ActionListener() {
	    public void actionPerformed(ActionEvent event) {
		Date now = new Date();
	        System.out.println("At the tone, the time is: " + now);
	        if(beep) Toolkit.getDefaultToolkit().beep();
	    }
	};
	Timer t = new Timer(interval, listener);
	t.start();
    }
}