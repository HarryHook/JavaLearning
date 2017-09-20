package com.algorithm.zuoshen;

public class MaxJump {
    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 0, 0, 0, 0, 5, 1, 0, 0, 0};
        int step = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                if (next == 0) {
                    break;
                }
                cur = next;
                next = 0;
                step++;
            }
            next = Math.max(next, arr[i] == 0 ? 0 : arr[i] + i);
            if (next >= arr.length) {
                break;
            }
        }
        if (next == 0)
            System.out.println(-1);
        else
            System.out.println(step + 1);
    }
}