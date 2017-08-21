package com.nowcoder.forjob.pingduoduo;

import java.util.Scanner;

public class FindMax3Nums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }

        System.out.println(getLargestMul_1(array));
    }

    public static long getLargestMul_2(long[] nums) {
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
        for (long num : nums) {
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }

            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }
        }
        long max = Math.max(max1 * max2 * max3, max1 * min1 * min2);
        return max;
    }

    public static long getLargestMul_1(long[] nums) {
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE, min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
        for (long num: nums) {
            if (num != 0) {
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num > max3) {
                    max3 = num;
                } else if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num > min1 && num < min2) {
                    min2 = num;
                }
            } else continue;

        }
        long max = Math.max(max1 * max2 * max3, max1 * min1 * min2);
        return max;
    }
}

