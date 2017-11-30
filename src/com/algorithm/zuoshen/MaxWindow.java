package com.algorithm.zuoshen;

import java.util.LinkedList;

public class MaxWindow {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2, 3, 3, 6, 7};
        int[] result = getMaxWindow(arr, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    private static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || arr.length == 0 || w < 1) {
            return new int[]{};
        }
        int index = 0;
        int[] result = new int[arr.length - w + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                //插入的新元素大于队尾的值时，删除队尾元素
                list.pollLast();
            }
            list.add(i);
            if (list.peekFirst() == i - w) {
                //队首不在窗口范围内，移除队首元素
                list.pollFirst();
            }
            //队首为最大值
            if (i >= w - 1) {
                result[index++] = arr[list.peekFirst()];
            }
        }

        return result;
    }
}
