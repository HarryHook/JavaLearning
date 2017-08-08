package com.thinking.in.java.innerclass;

public class DotNew {
    class Inner {
	void f() {
	    System.out.println("hello");
	}
    }
    public static void main(String[] args) {
	DotNew dn = new DotNew();
	DotNew.Inner dni = dn.new Inner();
	dni.f();
    }

}
