package com.nowcoder.forjob.wangyi;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        for(int i=n-1; i>=0; i-= 2) {
            System.out.print(nums[i] + " ");
        }
        for(int i=n%2; i<n-1; i+=2) {
            System.out.print(nums[i] + " ");
        }
    }
}
