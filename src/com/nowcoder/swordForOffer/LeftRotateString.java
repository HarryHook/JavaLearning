package com.nowcoder.swordForOffer;

public class LeftRotateString {
    public static String leftRotateString(String str, int n) {
        while (n-- > 0) {
            str = str.substring(1, str.length()) + str.charAt(0);
        }
        return str;

    }

    public static String leftRotateString1(String str, int n) {
        if (str == null || str.length() == 0) return "";

        int len = str.length();
        n = n % len;
        char[] seq = str.toCharArray();
        reverse(seq, 0, n - 1);
        reverse(seq, n, len - 1);
        reverse(seq, 0, len - 1);

        return String.valueOf(seq);

    }

    public static void reverse(char[] seq, int start, int end) {
        char temp = ' ';
        while (start < end) {
            temp = seq[start];
            seq[start++] = seq[end];
            seq[end--] = temp;
        }


    }

    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(leftRotateString1(str, 3));
    }
}
