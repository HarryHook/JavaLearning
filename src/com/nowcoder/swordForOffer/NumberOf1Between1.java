package com.nowcoder.swordForOffer;

import java.util.Scanner;

public class NumberOf1Between1 {
    public static int numberOf1Between1(int n) {
        int count = 0;
        while (n > 0) {
            char[] seq = String.valueOf(n).toCharArray();
            for (int i = 0; i < seq.length; i++) {
                if (seq[i] == '1') {
                    count++;
                }
            }
            n--;
        }

        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long start = System.currentTimeMillis();
        System.out.println(numberOf1Between1(n));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}
