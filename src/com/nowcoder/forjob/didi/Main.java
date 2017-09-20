package com.nowcoder.forjob.didi;

import java.util.Scanner;

public class Main {

    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int nextUglyIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyIndex < index) {
            int min = min(uglyNums[p2] * 2, uglyNums[p3] * 3, uglyNums[p5] * 5);
            uglyNums[nextUglyIndex] = min;
            while (uglyNums[p2] * 2 <= uglyNums[nextUglyIndex]) {
                p2++;
            }
            while (uglyNums[p3] * 3 <= uglyNums[nextUglyIndex]) {
                p3++;
            }
            while (uglyNums[p5] * 5 <= uglyNums[nextUglyIndex]) {
                p5++;
            }
            nextUglyIndex++;
        }
        return uglyNums[nextUglyIndex - 1];
    }

    private static int min(int n1, int n2, int n3) {
        int min = n1 < n2 ? n1 : n2;
        return min < n3 ? min : n3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            System.out.println(getUglyNumber(N));
        }
    }
}