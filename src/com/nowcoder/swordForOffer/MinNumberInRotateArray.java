package com.nowcoder.swordForOffer;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return array[0];
    }

    public int minNumberInRotateArray_v1(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = -1;
        while (low < high) {
            mid = (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            }
        }
        return array[low];
    }
}
