package com.nowcoder.forjob.wangyi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        int count = 0;
        int max = 0;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] != arr[i-1]) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 0;
            }

        }
        System.out.println(max+1);
        sc.close();
    }
}
