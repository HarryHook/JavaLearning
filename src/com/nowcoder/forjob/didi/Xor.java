package com.nowcoder.forjob.didi;

import java.util.Scanner;

public class Xor {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = 0;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == 0) {
                res++;
            } else if (a[i] == a[i + 1]) {
                res++;
                i++;
            }

        }
        if (a[n - 1] == 0) res++;
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(5^6);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            int count = 0;
            int[] flag = new int[num];
            for (int i = 0; i < num; i++) {
                if (arr[i] == 0) {
                    flag[i] = -1;
                    count++;
                } else {
                    int temp = arr[i];
                    for (int j = i - 1; j >= 0; j--) {
                        if (flag[j] == -1) {
                            break;
                        }
                        if ((temp ^ arr[j]) == 0) {
                            flag[i] = -1;
                            count++;
                            break;
                        } else {
                            temp = temp ^ arr[j];
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
