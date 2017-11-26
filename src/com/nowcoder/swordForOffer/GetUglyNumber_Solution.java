package com.nowcoder.swordForOffer;

public class GetUglyNumber_Solution {
    public static int getUglyNumber(int index) {
        if (index < 7) return index;
        int count = 6;
        for (int i = 7; i < Integer.MAX_VALUE; i++) {
            if (isUglyNum(i)) {
                count++;
            }
            if (count == index) {
                return i;
            }
        }
        return 0;
    }

    private static boolean isUglyNum(int n) {
        int i = 2;
        while (n != 1) {
            if (n % i == 0) {
                if (i == 2 || i == 3 || i == 5) {
                    n = n / i;
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }

    public static int getUglyNum(int index) {
        if (index < 7) return index;
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        int nextIndex = 1;
        while (nextIndex < index) {
            uglyNums[nextIndex] = Math.min(uglyNums[m2] * 2, Math.min(uglyNums[m3] * 3, uglyNums[m5] * 5));

            while (uglyNums[m2] * 2 <= uglyNums[nextIndex]) {
                m2++;
            }
            while (uglyNums[m3] * 3 <= uglyNums[nextIndex]) {
                m3++;
            }
            while (uglyNums[m5] * 5 <= uglyNums[nextIndex]) {
                m5++;
            }
            nextIndex++;
        }
        return uglyNums[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNum(10));
    }
}
