package com.algorithm.search;

public class BinarySearch {

    public static int binarySearch(int[] a, int value) {
	int left = 0;
	int right = a.length - 1;
	while (left <= right) {
	    int mid = left + (right - left) / 2;
	    if (a[mid] > value) {
		right = mid - 1;
	    } else if (a[mid] < value) {
		left = mid + 1;
	    } else {
		return mid;
	    }
	}
	return -1;
    }

    public static int bsSearch(int[] a, int left, int right, int value) {
	if (left > right) {
	    return -1;
	}
	int mid = left + (right - left) / 2;
	if (a[mid] < value) {
	    return bsSearch(a, mid + 1, right, value);
	} else if (a[mid] > value) {
	    return bsSearch(a, left, mid - 1, value);
	} else {
	    return mid;
	}
    }

    public static int BSearchUpperBound(int array[], int low, int high, int target) {
	if (low > high || target >= array[high])
	    return -1;

	int mid = (low + high) / 2;
	while (high > low) {
	    if (array[mid] > target) {
		high = mid;
	    } else {
		low = mid + 1;
	    }
	    mid = (low + high) / 2;
	}
	return mid;
    }

    public static void main(String[] args) {
	int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
	int pos = binarySearch(a, 8);
	
	System.out.println("value: 6 = " + pos);
    }

}
