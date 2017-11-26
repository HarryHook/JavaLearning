package com.nowcoder.swordForOffer;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array.length < 2 || array == null) {
            return new ArrayList<Integer>();
        }
        int high = array.length - 1;
        int low = 0;
        ArrayList<Integer> results = new ArrayList<Integer>();
        while (low < high) {
            int cur = array[low] + array[high];

            if (cur == sum) {
                results.add(array[low]);
                results.add(array[high]);
                break;
            }
            if (cur < sum) {
                low++;
            }
            if (cur > sum) {
                high--;
            }
        }
        return results;
    }
}
