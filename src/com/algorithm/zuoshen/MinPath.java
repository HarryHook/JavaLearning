package com.algorithm.zuoshen;


import java.util.HashMap;

public class MinPath {
    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int res1 = minpath1(m);
        System.out.println("res1 " + res1);
        int res2 = minpath2(m);
        System.out.println("res2 " + res2);
        HashMap<Integer, Integer> map = new HashMap<>();

    }

    public static int minpath1(int[][] m) {
        if (m == null || m.length == 0 || m == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static int minpath2(int[][] m) {
        if (m == null || m.length == 0 || m == null || m[0].length == 0) {
            return 0;
        }
        int more = Math.max(m.length, m[0].length);  //行列选最大的
        int less = Math.min(m.length, m[0].length);
        boolean rowmore = more == m.length;  //行数是否大于等于列数
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);     //按行扩展还是按列扩展
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[0][i] : m[i][0]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j - 1], arr[j]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }

        return arr[less - 1];
    }
}
