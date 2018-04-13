package com.nowcoder.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/*
给一个字符串， 求出各种回文串的组合情况
例如： aab， 返回
["a", "a", "b"]
["aa", "b"]
 */
public class PalindromeI {
    static ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
    static ArrayList<String> current = new ArrayList<>();

    private static ArrayList<ArrayList<String>> partition(String str) {
        findPalindrome(str, 0);
        return results;
    }

    private static void findPalindrome(String str, int left) {
        if (current.size() > 0 && left >= str.length()) {
            ArrayList<String> tempList = (ArrayList<String>) current.clone();
            results.add(tempList);
        }

        for (int right = left; right < str.length(); right++) {
            if (isPalindrome(str, left, right)) {
                if (left == right) {
                    current.add(Character.toString(str.charAt(left)));
                } else {
                    current.add(str.substring(left, right + 1));
                }
                //进行回溯
                findPalindrome(str, right + 1);
                //返回上一个状态
                current.remove(current.size() - 1);
            }

        }
    }

    private static boolean isPalindrome(String str, int left, int right) {
        if (left == right) {
            return true;
        }
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

//        System.out.println(partition("ab"));
        HashMap map = null;
        System.out.println("a".hashCode());

    }
}
