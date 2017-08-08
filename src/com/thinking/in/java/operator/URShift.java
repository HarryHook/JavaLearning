package com.thinking.in.java.operator;

public class URShift {

    public static void main(String[] args) {
	int i = -1;
	System.out.println(Integer.toBinaryString(i));
	i >>>= 10;
	System.out.println(Integer.toBinaryString(i));
	long l = -1;
	System.out.println(Long.toBinaryString(l));
	l >>>= 10;
	System.out.println(Long.toBinaryString(l));
	short s = -1;
	System.out.println(Integer.toBinaryString(s));
	s >>>= 10;
	System.out.println(Integer.toBinaryString(s));
	System.out.println(Integer.toBinaryString(s>>>10));
    }

}
