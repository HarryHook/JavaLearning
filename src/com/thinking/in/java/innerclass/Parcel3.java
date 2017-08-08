package com.thinking.in.java.innerclass;

public class Parcel3 {
    public Wrapping wrapping(int x) {
	return new Wrapping(x) {
	    public int value() {
		return super.value() * 47;
	    }
	};
    }
//    class MyWrapping implements Wrapping {
//	private int i = 11;
//	public int value() {
//	    return i;
//	}
//    }
//    public Wrapping wrapping() {
//	return new MyWrapping();
//    }
    public static void main(String[] args) {
	Parcel3 p = new Parcel3();
	Wrapping w = p.wrapping(10);
	System.out.println(w.value());
    }
}
