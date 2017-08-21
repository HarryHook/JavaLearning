package com.nowcoder.forjob.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        for(int i=0; i<n; i++){
            x[i] = sc.nextInt();
        }
        Arrays.sort(x);
        for(int i=1; i<n-1; i++) {
            if((x[i] - x[i-1]) != (x[i+1] -x[i])) {
                System.out.println("impossible");
                System.exit(0);
            }
        }
        System.out.println("possible");
    }
}
