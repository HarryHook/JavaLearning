package com.thinking.in.java.generics;


public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;

    public FourTuple(A a, B b, C c, D fourth) {
        super(a, b, c);
        this.fourth = fourth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth+ ")";
    }
}
