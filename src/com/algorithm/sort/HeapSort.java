package com.algorithm.sort;

public class HeapSort {
    public static void maxHeapDown(int a[], int start, int end) {
	int curr = start;
	int child = 2 * curr + 1; // 先选取左节点
	int tmp = a[curr];
	for (; child <= end; curr = child, child = 2 * curr + 1) {
	    if (child < end && a[child] < a[child + 1]) {
		child++; // 选取较大的子节点
	    }
	    if (tmp > a[child]) {
		break;
	    } else {
		a[curr] = a[child];
		a[child] = tmp;
	    }
	}
    }

    public static void heapSort(int[] a, int n) {
	// 先进行堆排序
	for (int i = n / 2 - 1; i >= 0; i--) {
	    maxHeapDown(a, i, n - 1);
	}
	// 交换数据
	for (int i = n - 1; i > 0; i--) {
	    exch(a, i, 0); // 当前最大的元素a[0]与最后一个元素交换
	    maxHeapDown(a, 0, i - 1); // 下沉
	}
    }

    public static void exch(int[] a, int i, int j) {
	int tmp = a[i];
	a[i] = a[j];
	a[j] = tmp;
    }

    public static void show(int[] a) {
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + " ");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	int[] a = { 20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80 };
	heapSort(a, a.length);
	show(a);
    }

}
