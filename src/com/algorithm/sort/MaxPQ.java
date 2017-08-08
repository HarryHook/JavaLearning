package com.algorithm.sort;

import java.util.Arrays;
import java.util.List;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
	pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
	return N == 0;
    }

    public int size() {
	return N;
    }

    public void insert(Key v) {
	pq[++N] = v;
	swim(N);
    }

    public Key delMax() {
	Key max = pq[1]; // 根节点获得最大元素
	exch(1, N--); // 将其和最后一个节点交换
	pq[N + 1] = null; // 防止对象游离
	sink(1); // 恢复堆的有序性
	return max;
    }

    private boolean less(int i, int j) {
	return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
	Key t = pq[i];
	pq[i] = pq[j];
	pq[j] = t;
    }

    private void swim(int k) {
	while (k > 1 && less(k / 2, k)) {
	    exch(k / 2, k);
	    k = k / 2;
	}
    }

    private void sink(int k) {
	while (2 * k <= N) {
	    int j = 2 * k;
	    if (j < N && less(j, j + 1)) {
		j++;
	    }
	    if (!less(k, j)) {
		break;
	    }
	    exch(k, j);
	    k = j;
	}
    }

    private void show(Comparable[] a) {
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + " ");
	}
	System.out.println("");
    }

    public static void main(String[] args) {
	MaxPQ<Character> pq = new MaxPQ<>(15);
	for (char c : "AEGHI".toCharArray()) {
	    pq.insert(c);
	}
    }
}
