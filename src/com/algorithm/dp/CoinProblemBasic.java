package com.algorithm.dp;

public class CoinProblemBasic {
    public static void main(String[] args) {
        int total = 11; // 需要凑 11 元
        int[] coins = {1, 2, 5}; // 硬币种类
        int length = coins.length;
        int[] dp  = new int[total + 1]; // 储存结果
        dp[0] = 0;
        for(int i = 1; i<= total; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<=total; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j<length; j++) {
                if(i >= coins[j]) {
                    min = Math.min(dp[i-coins[j]]+1, min);
                } else {
                    break;
                }
                dp[i] = min;
            }

        }
        System.out.println(dp[total]);
    }

}
