package com.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSubsequence {

    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
	while (in.hasNext()) {
	    int N = in.nextInt();
	    int[] a = new int[N];
	    int[] maxLen = new int[N];
	    for (int i = 0; i < N; i++) {
		a[i] = in.nextInt();
	    }
	    // 对a[0]特殊处理
	    if (a[1] >= 2) {
		maxLen[0] = 2;
		for (int i = 2; i < N; i++) {
		    if (a[i] > a[i - 1])
			maxLen[0]++;
		    else
			break;
		}
	    }
	    // 对a[N-1]特殊处理
	    maxLen[N - 1] = 2;
	    for (int i = N - 2; i >= 0; i--) {
		if (a[i] > a[i - 1])
		    maxLen[N - 1]++;
		else
		    break;
	    }
	    // 对标号是1~N-2的进行处理
	    for (int i = 1; i <= N - 2; i++) {
		if (a[i + 1] - a[i - 1] >= 2) {
		    maxLen[i] = 3;
		    for (int j = i - 1; j > 0; j--) {
			if (a[j] > a[j - 1])
			    maxLen[i]++;
			else
			    break;
		    }
		    for (int j = i + 1; j < N - 1; j++) {
			if (a[j + 1] > a[j])
			    maxLen[i]++;
			else
			    break;
		    }
		} else
		    maxLen[i] = 2;
	    }
	    Arrays.sort(maxLen);
	    System.out.println(maxLen[N - 1]);
	    in.close();
	}
    }
}
