package com.nowcoder.forjob.toutiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int t = 1;
            int cnt = 0;
            for (int i = 1; i < n; i++) {
                if (t < 3) {
                    if (a[i] - a[i - 1] <= 10)
                        t++;
                    else if (t == 1 && a[i] - a[i - 1] <= 20) {
                        cnt++;
                        t = 3;
                    } else {
                        cnt += 3 - t;
                        t = 1;
                    }
                } else
                    t = 1;
            }
            cnt += 3 - t;
            System.out.println(cnt);
        }
    }
}