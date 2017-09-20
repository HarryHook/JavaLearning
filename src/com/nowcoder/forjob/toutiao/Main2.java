package com.nowcoder.forjob.toutiao;

import java.util.Scanner;
import java.util.HashMap;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n; i++) {
            for(int j=0; j<2; j++) {
                a[i][j] = sc.nextInt();
                map.put(a[i][j], a[i][j+1]);
            }

        }

    }

}