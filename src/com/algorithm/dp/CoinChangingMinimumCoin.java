package com.algorithm.dp;

public class CoinChangingMinimumCoin {
    //当硬币无序时，判断能否凑成amount
    public static int minimumCoinBottomUp(int[] coins, int amount) {
        int T[] = new int[amount + 1];  //记录需要几枚硬币
        int R[] = new int[amount + 1];  //记录需要的硬币的索引
        T[0] = 0;
        for (int i = 1; i <= amount; i++) {
            T[i] = Integer.MAX_VALUE;
            R[i] = -1;
        }
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coins[j]) {
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        printCoinCombinations(R, coins);
        return T[amount];
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int total = 13;
        System.out.println(minimumCoinBottomUp(coins, total));

    }

    public static void printCoinCombinations(int[] R, int[] coins) {
        if(R[R.length-1] == -1) {
            System.out.println("没有解决方案");
            return;
        }
        int start = R.length -1;
        while (start != 0) {
            int j = R[start];
            System.out.println("coin: " + coins[j]);
            start = start - coins[j];
        }
        System.out.println("");
    }
}
