package com.nowcoder.forjob.pingduoduo;

import java.util.Arrays;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] h = new int[m];
        for (int i = 0; i < m; i++) {
            h[i] = sc.nextInt();
        }
        int res = 0;
        Arrays.sort(w);
        Arrays.sort(h);
        for (int i = 0, j = 0; i < m && j < n; i++) {
            if (h[i] >= w[j]) {
                res++;
                j++;
            }
        }
        System.out.println(res);
    }
}
