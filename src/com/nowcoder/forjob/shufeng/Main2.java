package com.nowcoder.forjob.shufeng;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long count = 0;
        for (long i = 0; i < n; i++) {
            if (isLuckyNum(i)) {
                count++;
            }
        }
        System.out.println(count);
    }


    static boolean isLuckyNum(long num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '4' || s.charAt(i) == '7') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
