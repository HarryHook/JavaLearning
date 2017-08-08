package com.thinking.in.java.innerclass;

public class OuterClass {
    class InnerClass {
	
    }
    public InnerClass ship() {
	return new InnerClass();
    }
    public static void main(String[] args) {
	InnerClass oClass = new OuterClass().ship();
    }

}
