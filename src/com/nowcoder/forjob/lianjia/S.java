package com.nowcoder.forjob.lianjia;

import java.util.*;

public class S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int Q = in.nextInt();
            int[] q = new int[Q];
            for (int i = 0; i < Q; i++) {
                q[i] = in.nextInt();
            }
            for (int i = 0; i < Q; i++) {
                int num = q[i];
                for (int j = 0; j < n; j++) {
                    if (num - arr[j] <= 0) {
                        System.out.println(j + 1);
                        break;
                    } else {
                        num -= arr[j];
                    }
                }
            }
        }
        in.close();
    }

}