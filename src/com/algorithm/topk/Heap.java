package com.algorithm.topk;

import java.util.Arrays;

public class Heap {
    int[] results;
    int root;

    public Heap(int[] array) {
        results = array;
        buildHeap();
//        sort();
    }

    //构建堆
    private void buildHeap() {
        for (int i = results.length / 2 - 1; i >= 0; i--) {
            heapify(results, i, results.length - 1);
        }
    }

    //大根堆，堆顶是最大元素
    private void heapify(int[] res, int start, int end) {
        int cur = start;
        int tmp = res[cur];
        int child = cur * 2 + 1;
        for (; child <= end; cur = child, child = 2 * child + 1) {
            if (child < end && res[child] < res[child + 1]) {
                child++;
            }
            if (tmp >= res[child]) break;
            else {
                res[cur] = res[child];
                res[child] = tmp;
            }
        }
    }

    //对堆进行排序
    public void sort() {
        for (int i = results.length - 1; i > 0; i--) {
            swap(results, 0, i);
            heapify(results, 0, i - 1);
        }
    }

    private void swap(int[] res, int i, int j) {
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }

    public void setRoot(int num) {
        results[0] = num;
        heapify(results, 0, results.length - 1);
//        sort();
    }
}
