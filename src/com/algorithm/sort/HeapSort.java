package com.algorithm.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};
        heapSort(a, a.length);
        show(a);

    }

    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void heapSort(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {   //二叉树中
            maxHeapDown(a, i, n - 1);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            maxHeapDown(a, 0, i - 1);
        }
    }

    private static void swap(int[] a, int first, int last) {
        int tmp = a[first];
        a[first] = a[last];
        a[last] = tmp;
    }

    private static void maxHeapDown(int[] a, int start, int end) {
        int cur = start;
        int tmp = a[cur];
        int child = 2 * cur + 1;
        for (; child <= end; cur = child, child = 2 * child + 1) {
            if (child < end && a[child] < a[child + 1]) {   //找到孩子中最大的那个
                child++;
            }
            if (tmp >= a[child]) {
                break;
            } else {    //父节点小于孩子时进行交换
                a[cur] = a[child];
                a[child] = tmp;
            }
        }
    }

}
