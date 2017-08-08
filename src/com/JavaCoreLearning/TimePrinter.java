package com.JavaCoreLearning;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TimePrinter implements ActionListener {

    public void actionPerformed(ActionEvent event) {
	Date now = new Date();
	System.out.println("At the tone, the time is: " + now);
	Toolkit.getDefaultToolkit().beep();
    }
}
