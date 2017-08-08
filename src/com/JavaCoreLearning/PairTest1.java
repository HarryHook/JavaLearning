package com.JavaCoreLearning;

public class PairTest1 {

    public static void main(String[] args) {
	String[] words = {"one", "two", "I", "have"};
	Pair<String> mm = ArrayAlg.minmax(words);
	System.out.println("min = " + mm.getFirst());
	System.out.println("max = " + mm.getSecond());

    }

}
class Pair<T> {
    
    public Pair() {
	first = null;
	second = null;
    }
    public Pair(T first, T second) {
	this.first = first;
	this.second = second;
    }
    
    public T getFirst() {
	return first;
    }
    public T getSecond() {
	return second;
    }
    public void setFirst(T newValue) {
	first = newValue;
    }
    public void setFSecond(T newValue) {
	second = newValue;
    }
    private T first;
    private T second;

}

class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
	if(a == null || a.length ==0) {
	    return null;
	}
	String min = a[0];
	String max = a[0];
	for(int i=0; i< a.length; i++) {
	    if(min.compareTo(a[i]) > 0) min = a[i];
	    if(max.compareTo(a[i]) < 0) max = a[i];
	}
	return new Pair<String>(min, max);
    }
}