package com.nowcoder;

import java.util.Scanner;

public class MaxFight {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();
	long maxSum = 0;
	long maxFight = 0;
	long add = 0;
	for(int i=0; i<n; i++) {
	    long fight = scanner.nextLong();
	    long potenial = scanner.nextLong();
	    if(fight < potenial) {
		maxFight = Math.max(maxFight, fight);
		add += potenial - fight;
	    } else {
		maxSum = Math.max(maxSum, fight+potenial);
	    }
	}
	System.out.println(add + Math.max(2*maxFight, maxSum));
	scanner.close();
    }
}
