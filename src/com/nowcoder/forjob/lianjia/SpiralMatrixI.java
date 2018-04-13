package com.nowcoder.forjob.lianjia;

import java.util.ArrayList;
/*
顺时针打印矩阵
 */
public class SpiralMatrixI {

    public static ArrayList<Integer> sprialMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                res.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > top; i--) {
                res.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;

            if (left == right) { //只有一列时
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
            } else if (top == bottom) { //只剩一行时
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(sprialMatrix(matrix));
    }
}
