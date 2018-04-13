package com.algorithm.dp;

public class Knapsack {
    //0,1背包问题
    public static void main(String[] args) {
        int num = 4;
        int capacity = 7;
        int[] w = {1, 3, 4, 5};
        int[] v = {1, 4, 5, 7};
        int[][] res = new int[num + 1][capacity + 1];


        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (j < w[i - 1]) {
                    res[i][j] = res[i - 1][j];
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - w[i - 1]] + v[i - 1]);
                }
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }
}