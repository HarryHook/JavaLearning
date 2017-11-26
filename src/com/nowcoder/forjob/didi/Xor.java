package com.nowcoder.forjob.didi;

import java.util.HashMap;
import java.util.Random;
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

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(5 ^ 6);
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

    public static void main(String[] args) {
//        int[] a = generate(10);
        int[] a = {3, 2, 1, 1, 1, 0, 2, 2};
        int ans = 0;
        int tmp = 0;
        for (int i = a.length - 1; i > 0; i--) {
            tmp ^= a[i] ^ a[i - 1];
            if (i > 0 && (tmp == 0 || a[i] == 0)) {
                ans++;
                i--;
            }
        }
        System.out.println(mostXor(a));
    }

    public static int[] generate(int n) {
        int[] a = new int[n];
        Random random = new Random(10);
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(100);
        }
        return a;
    }

    public static int mostXor(int[] a) {
        int ans = Integer.MIN_VALUE;
        int xor = 0;
        int[] mosts = new int[a.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
            if (map.containsKey(xor)) {
                int pre = map.get(xor);
                mosts[i] = pre == -1 ? 1 : (mosts[pre] + 1);
            }
            map.put(xor, i);
            ans = Math.max(ans, mosts[i]);
        }
        return ans;
    }
}
