package com.thinking.in.java.innerclass;

import java.util.Queue;

public class Parcel {
    class Contents {
	private int i=11;
	public int value(){
	    return i;
	}
    }
    class Destination {
	private String label;
	public Destination(String whereTo) {
	    label = whereTo;
	}
	
	String readLabel(){
	    return label;
	}
    }
    
    public Destination to(String s) {
	return new Destination(s);
    }
    
    public Contents contents() {
	return new Contents();
    }
    
    public void ship(String dest){
	Contents c = contents();
	Destination d = to(dest);
	System.out.println(d.readLabel());
    }
    
    public static void main(String[] args) {
	Parcel p = new Parcel();
	p.ship("Tasmania");
	Parcel q = new Parcel();
	Parcel.Contents c = q.contents();
	System.out.println(c.value());
	Parcel.Destination d = q.to("Borneo");
	p.ship("hello@");
	
    }

}
