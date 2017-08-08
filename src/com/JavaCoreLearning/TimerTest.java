package com.JavaCoreLearning;


import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class TimerTest {

    public static void main(String[] args) {
	ActionListener listener = new TimePrinter();
	
	Timer t = new Timer(1000, listener);
	t.start();
	
	JOptionPane.showMessageDialog(null, "Quit program?");
	System.exit(0);
    }

}
