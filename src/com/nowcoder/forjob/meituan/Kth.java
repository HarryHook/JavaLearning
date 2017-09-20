package com.nowcoder.forjob.meituan;

import java.util.Scanner;

public class Kth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        System.out.println(count(arr, n, k));

    }

    private static int count(int[] arr, int n, int k) {
        int sum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (res > n - i - 1) {
                break;
            }
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum % k == 0) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}
