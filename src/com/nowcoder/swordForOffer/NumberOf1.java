package com.nowcoder.swordForOffer;

public class NumberOf1 {
    public static int NumberOf1(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-5));
    }
}
