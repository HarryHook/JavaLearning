package com.algorithm.sort;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class BubbleSort {
    public static void bubbleSort(int[] a) {
	for (int i = a.length - 1; i > 0; i--) {
	    boolean flag = false;
	    for (int j = 0; j < i; j++) {
		if (a[j] > a[j + 1]) {
		    exch(a, j, j + 1);
		    flag = true;
		}
	    }
	    if(flag == false) break;
	}
    }

    public static void exch(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }
    private static void show(int[] a) {
	for(int i=0; i<a.length; i++) {
	    System.out.print(a[i] + " ");
	}
	System.out.println("");
    }
    public static void main(String[] args) {
	int []a={20, 10, 40, 30, 60, 50};
	bubbleSort(a);
	show(a);
    }

    

}
