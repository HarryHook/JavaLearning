package com.nowcoder.swordForOffer;

/*
当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
问rows*cols的矩阵，机器人上下左右行走能够达到多少个格子
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols];//记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int row, int col, int rows, int cols, int[][] flag, int threshold) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || numSum(row)+numSum(col) > threshold || flag[row][col] == 1) {
            return 0;
        }
        flag[row][col] = 1;
        return helper(row - 1, col, rows, cols, flag, threshold) +
                helper(row + 1, col, rows, cols, flag, threshold) +
                helper(row, col - 1, rows, cols, flag, threshold) +
                helper(row, col + 1, rows, cols, flag, threshold) + 1;

    }

    private int numSum(int num) {
        int sum = 0;
        do {
            sum += num % 10;
        } while ((num = num / 10) > 0);
        return sum;
    }
}
