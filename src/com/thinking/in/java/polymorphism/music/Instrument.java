package com.thinking.in.java.polymorphism.music;

public class Instrument {
    public void play(Note n) {
	System.out.println("Instrument.play()");
    }
    public String what(){
	return "Instrument";
    }
    public void adjust(){
	System.out.println("Adjusting Instument");
    }
}
