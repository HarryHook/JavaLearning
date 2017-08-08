package com.JavaCoreLearning;

public class StaticInnerClassTest {

    public static void main(String[] args) {
	double[] d = new double[20];
	for(int i=0; i<d.length; i++) {
	    d[i] = 10 * Math.random();
	}
	ArrayAlg1.Pair p = ArrayAlg1.minmax(d);
	System.out.println("min = " + p.getFirst());
	System.out.println("max = " + p.getSecond());
    }
}
class ArrayAlg1 {
    public static class Pair {
	public Pair(double f, double s) {
	    first = f;
	    second  = s;
	}
	public double getFirst() {
	    return first;
	}
	public double getSecond() {
	    return second;
	}
	private double first;
	private double second;
    }
    public static Pair minmax(double[] values) {
	double min = 10;
	double max = 0;
	for(double v : values) {
	    if(min > v) min = v;
	    if(max < v) max = v;
	}
	return new Pair(min, max);
    }
    
}
