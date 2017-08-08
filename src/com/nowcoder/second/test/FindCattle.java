package com.nowcoder.second.test;

public class FindCattle {

    public static int subCount(int arr[], int n, int k) {
	int[] mod = new int[k];
	mod[0]++;
	int s = 0;
	for (int i = 0; i < n; i++) {
	    s = (arr[i] + s) % k;
	    mod[s]++;
	}

	int result = 0; // Initialize result

	// Traverse mod[]
	for (int i = 0; i < k; i++) {
	    result += (mod[i] * (mod[i] - 1) % 1000000007) / 2;
	}

	return result ;
    }

    // Driver program to run the case
    public static void main(String[] args) {
	int arr[] = { 9, 7, 5, 3 };
	int k = 6;
	int n = 4;
	System.out.println(subCount(arr, n, k));

    }

}
