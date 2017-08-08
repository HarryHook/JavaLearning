package com.algorithm.sort;

public class ShellSort {
    public static void sort_1(Comparable[] a) {
	int N = a.length;
	int h = 1;
	while (h < N / 3)
	    h = h * 3 + 1;
	while (h >= 1) {
	    for (int i = h; i < N; i++) {
		for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
		    exch(a, j, j - h);
		}
	    }
	    h = h / 3;
	}
    }

    public static void sort_2(Comparable[] a) {
	for (int gap = a.length / 2; gap > 0; gap /= 2) {
	    for (int i = 0; i < gap; i++) {
		for (int j = i + gap; j < a.length && less(a[j], a[j - gap]); j += gap) {
		    char tmp = (char) a[j];
		    int k = j - gap;
		    while (k >= 0 && a[k].compareTo(tmp)>0) {
			a[k + gap] = a[k];
			k -= gap;
		    }
		    a[k + gap] = tmp;
		}
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
	Comparable[] a = { 's', 'h', 'e', 'l', 'l', 's', 'o', 'r', 't', 'e', 'x', 'a', 'm', 'p', 'l', 'e' };
	// sort_1(a);
	sort_2(a);
	show(a);
    }
}
