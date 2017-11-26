package com.algorithm.sort;

public class MergeSort {

    private static int[] aux;

    public static void sort(int[] a) {
        aux = new int[a.length];
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int lo, int hi) {
        if (hi <= lo || a == null) return;

        int mid = (lo + hi) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= hi) {
            if (a[i] <= a[j]) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
        }
        while (i <= mid) {
            aux[k++] = a[i++];
        }
        while (j <= hi) {
            aux[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            a[lo + i] = aux[i];
        }
    }


    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] a = {80, 30, 60, 40, 20, 10, 50, 70};
        sort(a);
        show(a);
        show(aux);
    }

}
