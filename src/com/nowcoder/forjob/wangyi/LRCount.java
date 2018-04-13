package com.nowcoder.forjob.wangyi;

import java.util.*;

public class LRCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            String str = sc.next();
            int countR = 0;
            int countL = 0;
            char[] array = str.toCharArray();
            for (int i = 0; i < n; i++) {
                if (array[i] == 'L') {
                    countL++;
                }
                if (array[i] == 'R') {
                    countR++;
                }
            }
            if (countR > countL) {
                int count1 = countR - countL;
                if (count1 % 2 == 0) {
                    if (count1 % 4 == 0) {
                        System.out.println("N");
                    } else {
                        System.out.println("S");
                    }
                } else {
                    System.out.println("W");
                }
            } else {
                int count2 = countL - countR;
                if (count2 % 2 == 0) {
                    if (count2 % 4 == 0) {
                        System.out.println("N");
                    } else {
                        System.out.println("S");
                    }
                } else {
                    System.out.println("E");
                }
            }
        }

}