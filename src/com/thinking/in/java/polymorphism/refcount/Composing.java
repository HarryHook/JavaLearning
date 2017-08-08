package com.thinking.in.java.polymorphism.refcount;

public class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared) {
	System.out.println("Creating " + this);
	this.shared = shared;
	this.shared.addRef();
    }


    protected void dispose() {
	System.out.println("Disposing " + this);
	shared.dispose();
    }

    public String toString() {
	return "Composing " + id;
    }
}
