package com.nowcoder.swordForOffer;

public class HashPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        boolean[] visitFlags = new boolean[matrix.length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, 0, visitFlags))
                    return true;
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int k, boolean[] visitFlags) {
        int index = row * cols + col;
        // 行列索引超限、当前字符已经被访问过、当前字符不等于目标字符序列的当前字符，直接返回false
        if (row < 0 || col < 0 || row >= rows || col >= cols || visitFlags[index] || matrix[index] != str[k]) {
            return false;
        }
        visitFlags[index] = true;   // 设置访问标记
        if (k == str.length - 1) {    // 递归结束条件，k已经到达目标字符序列的最后一个字符
            return true;
        }
        k++;    // 匹配目标字符序列的下一个字符
        if (hasPathCore(matrix, rows, cols, row + 1, col, str, k, visitFlags) ||
                hasPathCore(matrix, rows, cols, row - 1, col, str, k, visitFlags) ||
                hasPathCore(matrix, rows, cols, row, col + 1, str, k, visitFlags) ||
                hasPathCore(matrix, rows, cols, row, col - 1, str, k, visitFlags)) {
            return true;
        }
        // // 在当前字符的上、下、左、右的元素没有搜索到下一个目标字符，将访问标记重置为false，返回false；
        visitFlags[index] = false;
        return false;
    }
}
