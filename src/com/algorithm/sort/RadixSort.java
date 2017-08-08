package com.algorithm.sort;

public class RadixSort {

    public static void radixSort(int[] a) {
	int exp;
	int max = getMax(a);
	for (exp = 1; max / exp > 0; exp *= 10) {
	    countSort(a, exp);
	}
    }

    private static int getMax(int[] a) {
	int max = a[0];
	for (int i = 1; i < a.length; i++) {
	    if (a[i] > max) {
		max = a[i];
	    }
	}
	return max;
    }

    private static void countSort(int[] a, int exp) {
	int[] temp = new int[a.length];
	int[] buckets = new int[10];
	for (int i = 0; i < a.length; i++) {
	    buckets[(a[i] / exp) % 10]++; // 出现的次数统计放入桶中
	}
	for (int i = 1; i < 10; i++) {
	    buckets[i] += buckets[i - 1]; // 便于后续排序插入
	}
	for (int i = a.length - 1; i >= 0; i--) {
	    temp[buckets[(a[i] / exp) % 10] - 1] = a[i];
	    buckets[(a[i] / exp) % 10]--; // 插入一个,桶内元素减少一个
	}
	for (int i = 0; i < a.length; i++) {
	    a[i] = temp[i]; // 再将临时数组中的已排好序的数组返回给数组a
	}
    }

    private static void show(int[] a) {
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + " ");
	}
	System.out.println("");
    }

    public static void main(String[] args) {
	int[] a = { 53, 3, 542, 748, 14, 214, 154, 63, 616 };
	radixSort(a);
	show(a);
    }

}
