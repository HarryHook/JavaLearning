package com.algorithm.dp;

public class MaxSubString {
    public static void main(String[] args) {
        String str1 = "Ilovebigo";
        String str2 = "lovebigo2018";

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < len2; j++) {
            if (str2.charAt(j) == str1.charAt(0)) {
                dp[0][j] = 1;
            }
        }
        int res = 0;
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        System.out.println(res);
        System.out.println(getLcsStr(str1, str2));

    }

    public static String getLcsStr(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int row = 0;    //  斜线开始位置的行
        int col = ch2.length - 1;   //斜线开始位置的列
        int max = 0;
        int end = 0;
        while (row < ch1.length) {
                int i = row;
                int j = col;
            int len = 0;
            while (i < ch1.length && j < ch2.length) {
                if (ch1[i] != ch2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                if (len > max) {
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
            if (col > 0) {   //斜线开始的位置的列向左移动
                col--;
            } else {    //列移动到最左之后向下移动
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }
}
