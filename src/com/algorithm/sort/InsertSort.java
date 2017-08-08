package com.algorithm.sort;

public class InsertSort {

    public static void sort_1(Comparable[] a) {
	int N = a.length;
	for (int i = 1; i < N; i++) {
	    // a[i]插入到a[i-1]，a[i-2]，a[i-3]...
	    for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
		exch(a, j, j - 1);
	    }
	}
    }

    public static void sort_2(Comparable[] a) {
	int i, j, k;
	for (i = 1; i < a.length; i++) {
	    for (j = i - 1; j >= 0; j--) {
		if (less(a[j], a[i]))
		    break;
	    }
	    if (j != i - 1) {
		Comparable temp = a[i];
		for(k=i-1; k>j; k--) {
		    a[k+1] = a[k];
		}
		a[k+1] = temp;
	    }

	}
    }

    public static boolean less(Comparable v, Comparable w) {
	return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
	Comparable t = a[i];
	a[i] = a[j];
	a[j] = t;
    }

    public static void show(Comparable[] a) {
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + " ");
	}
	System.out.println("");
    }

    public static boolean isSorted(Comparable[] a) {
	for (int i = 1; i < a.length; i++) {
	    if (less(a[i], a[i - 1]))
		return false;
	}
	return true;
    }

    public static void main(String[] args) {
	Comparable[] a = { 's', 'o', 'r', 't', 'e', 'x', 'a', 'm', 'p', 'l', 'e' };
//	sort_1(a);
	sort_2(a);
	show(a);
    }

}
