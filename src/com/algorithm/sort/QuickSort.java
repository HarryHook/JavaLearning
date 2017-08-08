package com.algorithm.sort;

public class QuickSort {

    public static void sort_1(Comparable[] a, int lo, int hi) {
	if (hi <= lo)
	    return;
	int j = partition(a, lo, hi);
	sort_1(a, lo, j - 1);
	sort_1(a, j + 1, hi);
    }

    public static void sort_2(Comparable[] a, int lo, int hi) {
	if (lo < hi) {
	    int i = lo;
	    int j = hi;
	    Comparable x = a[lo];
	    while (i < j) {
		while (i < j && less(x, a[j])) {
		    j--;
		}
		if (i < j) {
		    a[i++] = a[j];
		}
		while (i < j && less(a[i], x)) {
		    i++;
		}
		if (i < j) {
		    a[j--] = a[i];
		}
	    }
	    a[i] = x;
	    sort_2(a, lo, i - 1);
	    sort_2(a, i + 1, hi);

	}
    }

    public static int partition(Comparable[] a, int lo, int hi) {
	int i = lo, j = hi + 1;
	Comparable x = a[lo];
	while (true) {
	    while (less(a[++i], x)) {
		if (i == hi)
		    break;
	    }
	    while (less(x, a[--j])) {
		if (j == lo)
		    break;
	    }
	    if (i >= j)
		break;
	    exch(a, i, j);
	}
	exch(a, lo, j);
	return j;
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

    public static void main(String[] args) {
	Comparable[] a = { 'k', 'r', 'a', 't', 'e', 'l', 'e', 'p', 'u', 'i', 'm', 'q', 'c', 'x', 'o', 's' };
	// sort_1(a, 0, a.length - 1);
	sort_2(a, 0, a.length - 1);
	show(a);
    }
}
