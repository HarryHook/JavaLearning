package com.thinking.in.java.innerclass;

public class Parcel2 {
    public Contents contents() {
	return new Contents() {
	    private int i = 11;
	    @Override
	    public int value() {
		return i;
	    }
	};
    }
    public static void main(String[] args) {
	Parcel2 p = new Parcel2();
	Contents c = p.contents();
	System.out.println(c.value());
    }

}
