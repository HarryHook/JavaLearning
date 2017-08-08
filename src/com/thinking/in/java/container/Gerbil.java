package com.thinking.in.java.container;

import java.util.ArrayList;

public class Gerbil {
    public static int counter;
    public int gerilNumber = counter++;
    public void hop() {
	System.out.println("geril: " + gerilNumber + " is hoping");
    }
    public static void main(String[] args) {
	ArrayList<Gerbil> list = new ArrayList<>();
	for(int i=0; i<4; i++) {
	    list.add(new Gerbil());
	}
	for(Gerbil g: list) {
	    g.hop();
	}
    }

}
