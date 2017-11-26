package com.nowcoder.forjob.zuoyebang;

public class ClimbStairs {
    public static int climbStairs_v1(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = 0;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else if (n > 3) {
            int[] res = new int[n];
            res[0] = 1;
            res[1] = 2;
            res[2] = 4;
            for (int i = 3; i < n; i++) {
                res[i] = res[i - 1] + res[i - 2] + res[i - 3];
            }
            result = res[n - 1];
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(climbStairs_v1(10));
    }
}
