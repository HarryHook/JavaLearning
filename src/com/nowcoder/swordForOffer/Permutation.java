package com.nowcoder.swordForOffer;

import java.util.ArrayList;

public class Permutation {
    public static ArrayList<String> permutation(String str) {
        char[] seq = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        result.add(str);
        int len = seq.length;
        while (true) {
            int p = len - 1;
            int q = 0;
            //从后往前找到第一个比后面元素小的位置。
            while (p >= 1 && seq[p - 1] >= seq[p]) p--;
            if (p == 0) break;
            q = p;// 从后往前第一个比后面元素小的点，若没有就是最后一个元素
            p--;
            //从之前那个找的元素开始往后招， 找到比p小的元素，直到末尾
            while (q < len && seq[q] > seq[p]) q++;
            q--;
            swap(seq, q, p); //交换这两个元素
            reverse(seq, p + 1);
            result.add(str.valueOf(seq));
        }
        return result;
    }

    private static void reverse(char[] seq, int start) {
        int len = seq.length;
        for (int i = 0; i < (len - start) >> 1; i++) {
            int p = start + i;
            int q = len - i - 1;
            if (p != q) {
                swap(seq, p, q);
            }
        }
    }

    private static void swap(char[] seq, int i, int j) {
        if (i == j) return;
        char tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }

    public static void permutation(char[] seq, int start, ArrayList<String> result) {
        if (start >= seq.length) {  //只对一个元素进行全排列时，输出
            result.add(String.valueOf(seq));
        } else {
            //对多个字符进行全排列
            for (int i = start; i < seq.length; i++) {
                // 交换数组第一个元素与后续的元素
                swap(seq, start, i);
                // 后续元素递归全排列
                permutation(seq, start + 1, result);
                // 将交换后的数组还原
                swap(seq, start, i);
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> results = new ArrayList<>();
        permutation(str.toCharArray(), 0, results);
        System.out.println(results);
//        System.out.println(permutation(str));
    }
}
