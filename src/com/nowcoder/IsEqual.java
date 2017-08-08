package com.nowcoder;

import java.util.Scanner;

public class IsEqual {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] data = new int[n];
	for (int i = 0; i < n; i++) {
	    data[i] = in.nextInt();
	    while(data[i]%2==0) {
                data[i]=data[i]/2;         
            }
	}
	
	int flag = data[0];
	boolean isEqual = true;
	for (int i = 1; i < n; i++) {
	    if (flag != data[i]) {
		isEqual = false;
	    }
	}
	if (isEqual) {
	    System.out.println("YES");
	} else {
	    System.out.println("No");
	}
	in.close();
    }
}
