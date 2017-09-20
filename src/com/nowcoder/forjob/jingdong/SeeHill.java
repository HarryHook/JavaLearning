package com.nowcoder.forjob.jingdong;

import java.util.Scanner;

public class SeeHill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] hill = new int[num];
            int res = 0;
            for (int i = 0; i < num; i++) {
                hill[i] = sc.nextInt();
            }

            for (int i = 0; i < num; i++) {
                for (int j = i + 1; j < num; j++) {
                    int x1 = getMax(hill, 0, i);
                    int x2 = getMax(hill, i + 1, j);
                    int x3 = getMax(hill, j + 1, num);

                    if ((hill[i] >= x2 && hill[j] >= x2)
                            || (hill[i] > getMax(x1, x3) && hill[j] >= getMax(x1, x3)))
                        res++;
                }
            }
            System.out.println(res);
        }
        sc.close();
    }

    private static int getMax(int a, int b) {

        return a > b ? a : b;
    }

    private static int getMax(int[] hill, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int max = hill[left];
        for (int i = left + 1; i < right; i++) {
            if (max < hill[i]) {
                max = hill[i];
            }
        }
        return max;
    }

}
