package com.nowcoder.forjob.sohu;


import java.util.Scanner;

public class MaxStep {
    public int[] spring;
    public int[] step;

    public static void main(String[] args) {
        MaxStep dsgh = new MaxStep();
        dsgh.start();
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        spring = new int[n];
        for (int i = 0; i < n; i++) {
            spring[i] = in.nextInt();
        }
        if (spring[0] == 0) {
            System.out.print(-1);
            return;
        }
        step = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            step[i] = 10000000;
        }
        step[0] = 0;
        for (int i = 0; i < n; i++) {
            if (spring[i] == 0) continue;
            for (int j = 1; j <= spring[i]; j++) {
                if (i + j > n) break;
                if (i + j == n) {
                    if (step[n] > step[i] + 1) {
                        step[n] = step[i] + 1;
                    }
                    break;
                }
                if (i + j < n) {
                    if (step[i + j] > step[i] + 1){
                        step[i + j] = step[i] + 1;
                    }
                }
            }
        }
        if (step[n - 1] == 10000000) {
            System.out.println(-1);
            return;
        }
        System.out.println(step[n]);
    }
}