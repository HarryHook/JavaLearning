package com.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class FindAverage {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	long[] data = new long[3 * n];
	for (int i = 0; i < data.length; i++) {
	    data[i] = in.nextLong();
	}
	Arrays.sort(data);
	int i = data.length - 2;
	long sum = 0;
	while (i >= n-1) {
	    sum += data[i];
	    i = i - 2;
	}
	System.out.println(sum);
    }
}