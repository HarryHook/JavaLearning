package com.JavaCoreLearning.threadLearning;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class BounceFrame extends JFrame {
    public BounceFrame() {

	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	setTitle("Bounce");
	panel = new BallPanel();
	add(panel, BorderLayout.CENTER);
	JPanel buttonPanel = new JPanel();
	addButton(buttonPanel, "Start", new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		addBall();

	    }
	});
	addButton(panel, "close", new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);

	    }
	});
	add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addButton(Container c, String tittle, ActionListener listener) {
	JButton button = new JButton(tittle);
	c.add(button);
	button.addActionListener(listener);
    }

    public void addBall() {
	Ball ball = new Ball();
	panel.add(ball);
	Runnable r = new BallRunnable(ball, panel);
	Thread t = new Thread(r);
	t.start();
	
    }

    private BallPanel panel;
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 350;
    public static final int STEPS = 1000;
    private static final int DELAY = 3;
}
