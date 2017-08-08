package com.JavaCoreLearning.threadLearning;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.time.Year;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

//多线程共享数据，多进程分别有自己的变量的完备集
public class Bounce {

    public static void main(String[] args) {
	JFrame frame = new BounceFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
}

class Ball {
    /*
     * move to the next position, reversing direction
     */
    public void move(Rectangle2D bounds) {
	x += dx;
	y += dx;
	if (x < bounds.getMinX()) {
	    x = bounds.getMinX();
	    dx = -dx;
	}
	if (x + XSIZE >= bounds.getMaxX()) {
	    x = bounds.getMaxX() - XSIZE;
	    dx = -dx;
	}
	if (y < bounds.getMinY()) {
	    y = bounds.getMinY();
	    dy = -dy;
	}
	if (y + YSIZE >= bounds.getMaxY()) {
	    y = bounds.getMaxY() - YSIZE;
	    dy = -dy;
	}
    }

    public Ellipse2D getShape() {
	return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }

    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
}

class BallPanel extends JPanel {
    public void add(Ball b) {
	balls.add(b);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	for (Ball b : balls) {
	    g2.fill(b.getShape());
	}
    }

    private ArrayList<Ball> balls = new ArrayList<Ball>();
}
