package com.algorithm.topk;

/*
自建堆实现实现topK问题
小根堆解决最大N, 每次和堆顶元素进行计较，比根大进行替换，再沉降
 */
public class topN {
    public static void main(String[] args) {
        int[] array = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        for (int num : topn(array, 6)) {
            System.out.println(num);
        }
    }
    public static int[] topn(int[] array, int n) {
        if(n >= array.length) {
            return array;
        }
        int[] topN = new int[n];
        for(int i=0; i<n; i++) {
            topN[i]=array[i];
        }
        Heap heap = new Heap(topN);
        heap.sort();
        for(int i=n; i<array.length; i++) {
            int value = array[i];
            int min = heap.results[0];
            if (value > min) {
                heap.setRoot(value);
                heap.sort();
            }
        }

        return  topN;
    }
}
