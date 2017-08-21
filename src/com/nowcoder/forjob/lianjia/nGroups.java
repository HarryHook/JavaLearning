package com.nowcoder.forjob.lianjia;

import java.util.Scanner;

public class nGroups {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0; i<n1; i++) {
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0; i<n2; i++) {
            arr2[i] = sc.nextInt();
        }
        int[] result = new int[n1+1];
        result[0] = 0;
        for(int i=1; i<n1+1; i++) {
            result[i] = arr1[i-1] + result[i-1];
        }

        for(int i=0; i<n2; i++) {
            for(int j=1; j<=n1; j++) {
                if(arr2[i] >=result[j-1] && arr2[i] <=result[j]) {
                    System.out.println(j);
                }
            }
        }
    }
}
