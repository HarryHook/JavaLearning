package com.nowcoder.swordForOffer;

import java.util.ArrayList;

public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        int pHigh = 2;
        int pLow = 1;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        while (pHigh > pLow) {
            int cur = (pHigh + pLow) * (pHigh - pLow + 1) / 2;
            if (cur < sum) {
                pHigh++;
            }

            if (cur == sum) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int i = pLow; i <= pHigh; i++) {
                    temp.add(i);
                }
                results.add(temp);
                pLow++;
            }
            if (cur > sum) {
                pLow++;
            }

        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequence(100));
    }
}
