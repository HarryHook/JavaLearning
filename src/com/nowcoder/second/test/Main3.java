package com.nowcoder.second.test;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] h_i = new int[n];
	for(int i=0; i<n; i++) {
	    h_i[i] = sc.nextInt();
	}
	int ans = 0;
	Arrays.sort(h_i);
	for(int i=2; i<n; i++) {
	    ans = Math.max(h_i[i]-h_i[i-2], ans);
	}
	System.out.println(ans);
	sc.close();
    }

}
