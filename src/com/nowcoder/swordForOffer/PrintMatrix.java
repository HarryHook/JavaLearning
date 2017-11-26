package com.nowcoder.swordForOffer;

import java.util.ArrayList;

public class PrintMatrix {
    public static ArrayList<Integer> printMatrixClockwise_v2(int[][] matrix) {
        int row = matrix.length;
        ArrayList<Integer> result = new ArrayList<>();
        while (row != 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
            if (row == 1) break;
            matrix = turn(matrix);
            row = matrix.length;
        }
        return result;
    }

    private static int[][] turn(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] newMatrix = new int[col][row - 1];
        for (int j = col - 1; j >= 0; j--) {
            for (int i = 1; i < row; i++) {
                newMatrix[col - j - 1][i - 1] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static ArrayList<Integer> printMatrixClockwise_v1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        if (row <= 0 || col <= 0) {
            return result;
        }
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;

        while (left <= right && top <= bottom) {
            //left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            //top to bottom
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            //right to left
            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            //bottom to top
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {5, 6, 7, 8, 9},
                {9, 10, 11, 12, 13},
                {13, 14, 15, 16, 17}
        };
        System.out.println(printMatrixClockwise_v1(matrix));
    }
}
