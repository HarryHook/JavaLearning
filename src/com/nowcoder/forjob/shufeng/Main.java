package com.nowcoder.forjob.shufeng;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] res = solve(a, n);
        for (int num : res) {
            System.out.println(num);
        }
    }

    static int[] solve(int[] a, int n) {
        int[] b = new int[n];
        b[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            b[i] = a[i] + a[i + 1];
        }
        return b;
    }
}
