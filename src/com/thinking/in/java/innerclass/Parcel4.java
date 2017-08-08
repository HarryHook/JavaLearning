package com.thinking.in.java.innerclass;


public class Parcel4 {
    public Destination destination(final String dest) {
	return new Destination() {
	    private String label = dest;
	    public String readLabel(){
		return label;
	    }
	};
    }
    public static void main(String[] args) {
	Parcel4 p = new Parcel4();
	Destination d = p.destination("TTT");
    }
}
