package com.algorithm.dp;

import java.util.HashMap;

public class MaxSumOfArrray {
    public static void main(String[] args) {
        int[] nums = generRandomIntArray(10);
        int[] dp = new int[10];
        dp[0] = nums[0];
        int res = nums[0];
        for (int num : nums) {
            System.out.print(num + " ");
        }
        HashMap<Integer,String> map = new HashMap<>();
        System.out.println();
        for (int i = 1; i < 10; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        System.out.println(res);
    }

    private static int[] generRandomIntArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (-50 + Math.random() * 100);
        }
        return arr;
    }
}
