package com.algorithm.dp;

public class CoinsCombination {

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 1000;
        int combinations[] = new int[amount + 1];
        combinations[0] = 1;
        for(int coin:coins) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coin) {
                    combinations[j] += combinations[j - coin];
                }
            }
        }
        System.out.println(combinations[amount]);
    }
}
