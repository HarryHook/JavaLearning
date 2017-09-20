package com.nowcoder.forjob.wangyi.day0909;

import java.util.Scanner;

public class TimesFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int cnt1 = 0;
            int cnt2 = 0;
            int cnt4 = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] % 4 == 0) {
                    cnt4++;
                } else if (arr[i] % 2 == 0) {
                    cnt2++;
                } else {
                    cnt1++;
                }
            }
            if (cnt2 == 0) {
                if (cnt4 >= cnt1 - 1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                if (cnt4 >= cnt1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }

        }

    }

}
