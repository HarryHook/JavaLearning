package com.nowcoder.forjob.zuoyebang;

import java.util.Random;

public class MaxHeap {

    static int[] items;
    int currentSize = 0;

    // 初始化为size + 1，从下标1开始保存元素。
    public MaxHeap(int size) {
        items = new int[size + 1];
    }

    // 插入元素
    /*
    如果比堆顶数字小，则替换堆顶元素并重新调整堆为最大堆；
    如果比堆顶数字大，就跳过这个数字（比最大的数要大，没资格留下来），继续向后读取。
     */
    public void insert(int x) {
        if (currentSize == items.length - 1) {
            if (compare(x, items[1]) < 0) {  //比堆顶大
                return;
            } else if (compare(x, items[1]) > 0) { //比堆顶小，删除堆顶再插入
                deleteMax();
            }
        }
        int hole = ++currentSize;
        for (items[0] = x; compare(x, items[hole / 2]) < 0; hole /= 2) {
            items[hole] = items[hole / 2];
        }
        items[hole] = x;
    }

    // 删除最大堆中最大的元素
    public int deleteMax() {
        int max = items[1];
        items[1] = items[currentSize--];
        percolateDown(1);
        return max;
    }

    // 下滤
    public void percolateDown(int hole) {
        int child;
        int temp = items[1];  //堆顶元素
        for (; hole * 2 <= currentSize; hole = child) {
            child = 2 * hole;
            //找到最大的孩子
            if (child != currentSize && compare(items[child + 1], items[child]) == -1) {
                child++;
            }
            //交换
            if (compare(items[child], temp) < 0) {
                items[hole] = items[child];
            } else {
                break;
            }
        }
        items[hole] = temp;
    }

    // 制定比较规则
    public static int compare(int a, int b) {
        if (a > b) {
            return -1;
        } else if (a < b) {
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MaxHeap heap = new MaxHeap(10);
        Random random = new Random();
        for (int i = 0; i < 1000000000; i++) {
            heap.insert(random.nextInt(Integer.MAX_VALUE));
        }
        for (int num : heap.items) {
            System.out.print(num + " ");
        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + "ms");
    }

}