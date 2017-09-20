package com.nowcoder.forjob.meituan;

import java.util.Scanner;

public class Main1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[7];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[a[i] % 7]++;
        }

        long count = 0;
        if (b[0] > 0) count = b[0] * (b[0] - 1);
        for (int i = 0; i < n; i++) {
            int temp = a[i] % 7;
            if (temp != 0) {
                for (int j = 1; j < 7; j++) {
                    if (Long.parseLong((j + "" + a[i])) % 7 == 0) {
                        count += b[j];
                        if (j == temp) {
                            count--;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}

