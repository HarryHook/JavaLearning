package com.thinking.in.java.exception;

public class TryTest {

    public static int f() {
	try {
	    return 1;
	}catch (Exception e) {
	    
	} finally {
	    return 2;
	}
    }
    public static void main(String[] args) {
	System.out.println(f());
    }

}
