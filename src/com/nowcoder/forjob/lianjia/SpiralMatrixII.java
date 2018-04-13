package com.nowcoder.forjob.lianjia;

import java.util.ArrayList;

//对矩阵按顺时针插入递增元素
public class SpiralMatrixII {
    public static int[][] sprialMatrix(int n) {
        int[][] res = new int[n][n];
        if (n <= 0) return res;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int count = 1;
        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                res[top][i] = count++;
            }
            for (int i = top; i < bottom; i++) {
                res[i][right] = count++;
            }
            for (int i = right; i > left; i--) {
                res[bottom][i] = count++;
            }
            for (int i = bottom; i > top; i--) {
                res[i][left] = count++;
            }
            top++;
            bottom--;
            left++;
            right--;

            if (n % 2 == 1) res[n / 2][n / 2] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = sprialMatrix(n);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
